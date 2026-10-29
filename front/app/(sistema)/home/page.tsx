"use client";

import axios from "axios";
import { useEffect, useMemo, useState } from "react";

type ItemStatus = {
  status: string;
};

type MatriculaDashboard = ItemStatus & {
  plano: string;
  dataInicio: string;
};

const coresGrafico = ["#F5C518", "#d4d4d8", "#71717a", "#a1a1aa", "#52525b"];

function IconeCard({ tipo }: { tipo: string }) {
  const classe = "h-6 w-6";

  if (tipo === "alunos" || tipo === "usuarios") {
    return (
      <svg className={classe} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
        <circle cx="12" cy="7" r="3" />
        <path d="M5 21c.5-5 2.8-7.5 7-7.5S18.5 16 19 21" />
      </svg>
    );
  }

  if (tipo === "matriculas") {
    return (
      <svg className={classe} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
        <rect x="5" y="4" width="14" height="16" rx="2" />
        <path d="M9 2v4M15 2v4M8 10h8M8 14h5" />
      </svg>
    );
  }

  return (
    <svg className={classe} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
      <rect x="4" y="6" width="16" height="12" rx="2" />
      <path d="M8 10h8M8 14h5" />
    </svg>
  );
}

export default function Home() {
  const [alunos, setAlunos] = useState<ItemStatus[]>([]);
  const [matriculas, setMatriculas] = useState<MatriculaDashboard[]>([]);
  const [planos, setPlanos] = useState<ItemStatus[]>([]);
  const [usuarios, setUsuarios] = useState<ItemStatus[]>([]);

  useEffect(() => {
    carregarDados();
  }, []);

  const carregarDados = async () => {
    const resultados = await Promise.allSettled([
      axios.get<ItemStatus[]>("http://localhost:8080/alunos"),
      axios.get<MatriculaDashboard[]>("http://localhost:8080/matriculas"),
      axios.get<ItemStatus[]>("http://localhost:8080/planos"),
      axios.get<ItemStatus[]>("http://localhost:8080/usuarios"),
    ]);

    if (resultados[0].status === "fulfilled") setAlunos(resultados[0].value.data);
    if (resultados[1].status === "fulfilled") setMatriculas(resultados[1].value.data);
    if (resultados[2].status === "fulfilled") setPlanos(resultados[2].value.data);
    if (resultados[3].status === "fulfilled") setUsuarios(resultados[3].value.data);
  };

  const historicoMatriculas = useMemo(() => {
    const hoje = new Date();

    return Array.from({ length: 6 }, (_, indice) => {
      const data = new Date(hoje.getFullYear(), hoje.getMonth() - (5 - indice), 1);
      const mes = data.getMonth();
      const ano = data.getFullYear();

      const total = matriculas.filter((matricula) => {
        const dataMatricula = new Date(matricula.dataInicio);
        return dataMatricula.getMonth() === mes && dataMatricula.getFullYear() === ano;
      }).length;

      return {
        label: data.toLocaleDateString("pt-BR", { month: "short" }).replace(".", ""),
        total,
      };
    });
  }, [matriculas]);

  const distribuicaoPlanos = useMemo(() => {
    const mapa = new Map<string, number>();

    matriculas.forEach((matricula) => {
      if (matricula.plano) {
        mapa.set(matricula.plano, (mapa.get(matricula.plano) || 0) + 1);
      }
    });

    return Array.from(mapa.entries())
      .map(([nome, total]) => ({ nome, total }))
      .sort((a, b) => b.total - a.total)
      .slice(0, 5);
  }, [matriculas]);

  const totalDistribuicao = distribuicaoPlanos.reduce((total, item) => total + item.total, 0);

  const gradientePlanos = useMemo(() => {
    if (totalDistribuicao === 0) return "#18181b";

    let acumulado = 0;
    const partes = distribuicaoPlanos.map((item, indice) => {
      const inicio = (acumulado / totalDistribuicao) * 100;
      acumulado += item.total;
      const fim = (acumulado / totalDistribuicao) * 100;
      return `${coresGrafico[indice % coresGrafico.length]} ${inicio}% ${fim}%`;
    });

    return `conic-gradient(${partes.join(", ")})`;
  }, [distribuicaoPlanos, totalDistribuicao]);

  const maximoHistorico = Math.max(...historicoMatriculas.map((item) => item.total), 1);

  const cards = [
    { titulo: "Total de Alunos", valor: alunos.length, icone: "alunos" },
    {
      titulo: "Matrículas Ativas",
      valor: matriculas.filter((item) => item.status === "ATIVO").length,
      icone: "matriculas",
    },
    {
      titulo: "Planos Ativos",
      valor: planos.filter((item) => item.status === "ATIVO").length,
      icone: "planos",
    },
    { titulo: "Total de Usuários", valor: usuarios.length, icone: "usuarios" },
  ];

  return (
    <div className="min-h-full bg-[#070707] px-6 py-8 text-white md:px-10">
      <div className="mx-auto max-w-7xl">
        <div className="mb-8">
          <h1 className="text-4xl font-black tracking-tight">Home</h1>
          <p className="mt-2 text-sm text-zinc-500">
            Bem-vindo ao sistema de gestão da TigreGym
          </p>
        </div>

        <div className="grid gap-4 sm:grid-cols-2 xl:grid-cols-4">
          {cards.map((card) => (
            <div
              key={card.titulo}
              className="rounded-xl border border-zinc-800 bg-[#0d1215] p-5"
            >
              <div className="flex items-center gap-4">
                <div className="flex h-12 w-12 items-center justify-center rounded-xl bg-[#F5C518]/10 text-[#F5C518]">
                  <IconeCard tipo={card.icone} />
                </div>

                <div>
                  <p className="text-sm text-zinc-500">{card.titulo}</p>
                  <p className="mt-1 text-3xl font-black">{card.valor}</p>
                </div>
              </div>
            </div>
          ))}
        </div>

        <div className="mt-5 grid gap-5 xl:grid-cols-[1.45fr_1fr]">
          <section className="rounded-2xl border border-zinc-800 bg-[#0d1215] p-6">
            <div className="mb-6">
              <h2 className="text-lg font-bold">Evolução de Matrículas</h2>
              <p className="mt-1 text-sm text-zinc-500">Últimos 6 meses</p>
            </div>

            <div className="flex h-64 items-end gap-3 border-b border-zinc-800 px-2 pb-0">
              {historicoMatriculas.map((item) => (
                <div key={item.label} className="flex h-full flex-1 flex-col justify-end">
                  <div className="mb-2 text-center text-xs font-bold text-zinc-300">
                    {item.total}
                  </div>
                  <div
                    className="mx-auto w-full max-w-14 rounded-t-md bg-[#F5C518]"
                    style={{
                      height: item.total === 0 ? "4px" : `${Math.max((item.total / maximoHistorico) * 100, 8)}%`,
                    }}
                  />
                  <div className="py-3 text-center text-xs capitalize text-zinc-500">
                    {item.label}
                  </div>
                </div>
              ))}
            </div>
          </section>

          <section className="rounded-2xl border border-zinc-800 bg-[#0d1215] p-6">
            <h2 className="text-lg font-bold">Alunos por Plano</h2>
            <p className="mt-1 text-sm text-zinc-500">Distribuição das matrículas</p>

            <div className="mt-8 flex flex-col items-center gap-8 sm:flex-row xl:flex-col 2xl:flex-row">
              <div
                className="relative h-44 w-44 shrink-0 rounded-full"
                style={{ background: gradientePlanos }}
              >
                <div className="absolute inset-8 flex items-center justify-center rounded-full bg-[#0d1215] text-center">
                  <div>
                    <p className="text-3xl font-black">{totalDistribuicao}</p>
                    <p className="text-xs text-zinc-500">Matrículas</p>
                  </div>
                </div>
              </div>

              <div className="w-full space-y-3">
                {distribuicaoPlanos.length === 0 && (
                  <p className="text-sm text-zinc-500">Nenhuma matrícula cadastrada.</p>
                )}

                {distribuicaoPlanos.map((item, indice) => (
                  <div key={item.nome} className="flex items-center justify-between gap-4 text-sm">
                    <div className="flex min-w-0 items-center gap-2">
                      <span
                        className="h-2.5 w-2.5 shrink-0 rounded-full"
                        style={{ background: coresGrafico[indice % coresGrafico.length] }}
                      />
                      <span className="truncate text-zinc-300">{item.nome}</span>
                    </div>
                    <span className="font-bold text-white">{item.total}</span>
                  </div>
                ))}
              </div>
            </div>
          </section>
        </div>
      </div>
    </div>
  );
}
