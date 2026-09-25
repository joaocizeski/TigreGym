"use client";

import Link from "next/link";
import UsuarioForm from "../../components/UsuarioForm";
import { useParams, useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import { Plano } from "../../plano";
import axios from "axios";

export default function EditarPlano() {
  const parametro = useParams();

  // Pega o código que veio pela URL
  const codigo = Number(parametro.codigo);

  const [plano, setPlano] = useState<Plano | null>(null);
  const router = useRouter();

  useEffect(() => {
    buscarDados();
  }, []);

  // Busca o plano pelo código
  const buscarDados = async () => {
    const valorPlanoBack = await axios.get<Plano>(
      "http://localhost:8080/planos/" + codigo
    );

    if (valorPlanoBack.status == 200) {
      setPlano(valorPlanoBack.data);
    } else {
      router.push("/plano");
    }
  };

  if (!plano) {
    return <div className="p-8 text-white">Carregando dados ...</div>;
  }

  return (
    <div className="w-full bg-black px-6 py-10 md:px-10">
      <div className="max-w-4xl mx-auto">
        <div className="mb-10">
          <Link
            href="/plano"
            className="inline-flex items-center gap-2 text-sm font-medium text-zinc-400 transition hover:text-yellow-400"
          >
            <span className="flex h-8 w-8 items-center justify-center rounded-lg border border-zinc-800 bg-zinc-900 transition hover:border-yellow-400/40">
              ←
            </span>

            Voltar para Listagem
          </Link>

          <div className="mt-6">
            <p className="text-yellow-400 text-sm font-bold tracking-[3px] mb-2">
              TIGREGYM
            </p>

            <h1 className="text-4xl md:text-5xl font-black text-white">
              Editar Plano {codigo}
            </h1>

            <p className="text-zinc-500 mt-3">
              Preencha os dados para editar o plano.
            </p>
          </div>
        </div>

        <UsuarioForm planoExistente={plano} />
      </div>
    </div>
  );
}
