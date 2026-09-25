"use client";

import Link from "next/link";
import { useState } from "react";
import { Plano, PlanoFormProps } from "../plano";
import axios from "axios";
import { useRouter } from "next/navigation";

export default function UsuarioForm({ planoExistente }: PlanoFormProps) {
  const router = useRouter();

  // Usa os dados existentes quando for edição
  const [plano, setPlano] = useState<Plano>(
    planoExistente || new Plano(null, "", "", "", "", "ATIVO")
  );

  // Muda somente o campo que foi digitado
  const handlerChange = (
    campo: "nome" | "descricao" | "valor" | "duracaoEmMeses",
    valor: string
  ) => {
    setPlano(
      (valorAnterior) =>
        new Plano(
          valorAnterior.id,
          campo === "nome" ? valor : valorAnterior.nome,
          campo === "descricao" ? valor : valorAnterior.descricao,
          campo === "valor" ? valor : valorAnterior.valor,
          campo === "duracaoEmMeses" ? valor : valorAnterior.duracaoEmMeses,
          valorAnterior.status
        )
    );
  };

  const handlerSalvar = async (formData: FormData) => {
    // Se o plano já existe, edita ele
    if (planoExistente) {
      var dadosRetorno = await axios.put(
        "http://localhost:8080/planos/" + plano.id,
        plano
      );

      if (dadosRetorno.status == 200) {
        alert("Plano foi salvo com sucesso!");
      } else {
        alert(dadosRetorno.data);
        return;
      }
    } else {
      // Se não existe, cria um novo
      var dadosRetorno = await axios.post(
        "http://localhost:8080/planos",
        plano
      );

      if (dadosRetorno.status == 200) {
        alert("Plano foi salvo com sucesso!");
      } else {
        alert(dadosRetorno.data);
        return;
      }
    }

    router.push("/plano");
  };

  return (
    <form action={handlerSalvar} className="w-full">
      <div className="bg-zinc-950 border border-zinc-800 rounded-2xl p-8 shadow-2xl">
        <div className="mb-8">
          <p className="text-yellow-400 text-sm font-bold tracking-[3px]">
            TIGREGYM
          </p>

          <h2 className="text-3xl font-black text-white mt-2">
            Cadastro de plano
          </h2>

          <p className="text-zinc-500 mt-2">Preencha os dados do plano.</p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Nome:
            </label>

            <input
              name="nome"
              value={plano.nome}
              required
              onChange={(e) => handlerChange("nome", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite o nome do plano"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Valor:
            </label>

            <input
              name="valor"
              value={plano.valor}
              required
              onChange={(e) => handlerChange("valor", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite o valor"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Descrição:
            </label>

            <input
              name="descricao"
              value={plano.descricao}
              required
              onChange={(e) => handlerChange("descricao", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite a descrição"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Duração:
            </label>

            <input
              name="duracaoEmMeses"
              type="datetime-local"
              value={plano.duracaoEmMeses}
              required
              onChange={(e) => handlerChange("duracaoEmMeses", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>
        </div>

        <div className="flex justify-end gap-3 mt-8">
          <Link
            href="/plano"
            className="px-5 py-3 rounded-lg border border-zinc-700 text-zinc-300 hover:bg-zinc-900 transition"
          >
            Cancelar
          </Link>

          <button
            type="submit"
            className="px-6 py-3 rounded-lg bg-yellow-400 text-black font-bold hover:bg-yellow-300 transition"
          >
            Salvar
          </button>
        </div>
      </div>
    </form>
  );
}
