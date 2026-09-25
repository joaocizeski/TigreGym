"use client";

import Link from "next/link";
import { useState } from "react";
import { Matricula, MatriculaFormProps } from "../matricula";
import axios from "axios";
import { useRouter } from "next/navigation";

export default function UsuarioForm({
  matriculaExistente,
}: MatriculaFormProps) {
  const router = useRouter();

  // Usa os dados existentes quando for edição
  const [matricula, setMatricula] = useState<Matricula>(
    matriculaExistente || new Matricula(null, "", "", "", "", "ATIVO")
  );

  // Muda somente o campo que foi digitado
  const handlerChange = (
    campo: "aluno" | "plano" | "dataInicio" | "dataVencimento",
    valor: string
  ) => {
    setMatricula(
      (valorAnterior) =>
        new Matricula(
          valorAnterior.id,
          campo === "aluno" ? valor : valorAnterior.aluno,
          campo === "plano" ? valor : valorAnterior.plano,
          campo === "dataInicio" ? valor : valorAnterior.dataInicio,
          campo === "dataVencimento" ? valor : valorAnterior.dataVencimento,
          valorAnterior.status
        )
    );
  };

  const handlerSalvar = async (formData: FormData) => {
    // Se a matrícula já existe, edita ela
    if (matriculaExistente) {
      var dadosRetorno = await axios.put(
        "http://localhost:8080/matriculas/" + matricula.id,
        matricula
      );

      if (dadosRetorno.status == 200) {
        alert("Matrícula foi salva com sucesso!");
      } else {
        alert(dadosRetorno.data);
        return;
      }
    } else {
      // Se não existe, cria uma nova
      var dadosRetorno = await axios.post(
        "http://localhost:8080/matriculas",
        matricula
      );

      if (dadosRetorno.status == 200) {
        alert("Matrícula foi salva com sucesso!");
      } else {
        alert(dadosRetorno.data);
        return;
      }
    }

    router.push("/matricula");
  };

  return (
    <form action={handlerSalvar} className="w-full">
      <div className="bg-zinc-950 border border-zinc-800 rounded-2xl p-8 shadow-2xl">
        <div className="mb-8">
          <p className="text-yellow-400 text-sm font-bold tracking-[3px]">
            TIGREGYM
          </p>

          <h2 className="text-3xl font-black text-white mt-2">
            Cadastro de matrícula
          </h2>

          <p className="text-zinc-500 mt-2">
            Preencha os dados da matrícula.
          </p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Aluno:
            </label>

            <input
              name="aluno"
              value={matricula.aluno}
              required
              onChange={(e) => handlerChange("aluno", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite o aluno"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Plano:
            </label>

            <input
              name="plano"
              value={matricula.plano}
              required
              onChange={(e) => handlerChange("plano", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite o plano"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Data de início:
            </label>

            <input
              name="dataInicio"
              type="datetime-local"
              value={matricula.dataInicio}
              required
              onChange={(e) => handlerChange("dataInicio", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Data de vencimento:
            </label>

            <input
              name="dataVencimento"
              type="datetime-local"
              value={matricula.dataVencimento}
              required
              onChange={(e) => handlerChange("dataVencimento", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>
        </div>

        <div className="flex justify-end gap-3 mt-8">
          <Link
            href="/matricula"
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
