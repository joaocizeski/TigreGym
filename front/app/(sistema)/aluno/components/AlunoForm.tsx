"use client";

import Link from "next/link";
import { useState } from "react";
import { Aluno, AlunoFormProps } from "../aluno";
import axios from "axios";
import { useRouter } from "next/navigation";

export default function AlunoForm({ alunoExistente }: AlunoFormProps) {
  const router = useRouter();

  // Usa os dados existentes quando for edição
  const [aluno, setAluno] = useState<Aluno>(
    alunoExistente || new Aluno(null, "", "", "", "", "", "ATIVO")
  );

  // Muda somente o campo que foi digitado
  const handlerChange = (
    campo: "nome" | "cpf" | "dataNascimento" | "telefone" | "email",
    valor: string
  ) => {
    setAluno(
      (valorAnterior) =>
        new Aluno(
          valorAnterior.id,
          campo === "nome" ? valor : valorAnterior.nome,
          campo === "cpf" ? valor : valorAnterior.cpf,
          campo === "dataNascimento" ? valor : valorAnterior.dataNascimento,
          campo === "telefone" ? valor : valorAnterior.telefone,
          campo === "email" ? valor : valorAnterior.email,
          valorAnterior.status
        )
    );
  };

  const handlerSalvar = async (formData: FormData) => {
    // Se o aluno já existe, edita ele
    if (alunoExistente) {
      var dadosRetorno = await axios.put(
        "http://localhost:8080/alunos/" + aluno.id,
        aluno
      );

      if (dadosRetorno.status == 200) {
        alert("Aluno foi salvo com sucesso!");
      } else {
        alert(dadosRetorno.data);
        return;
      }
    } else {
      // Se não existe, cria um novo
      var dadosRetorno = await axios.post(
        "http://localhost:8080/alunos",
        aluno
      );

      if (dadosRetorno.status == 200) {
        alert("Aluno foi salvo com sucesso!");
      } else {
        alert(dadosRetorno.data);
        return;
      }
    }

    router.push("/aluno");
  };

  return (
    <form action={handlerSalvar} className="w-full">
      <div className="bg-zinc-950 border border-zinc-800 rounded-2xl p-8 shadow-2xl">
        <div className="mb-8">
          <p className="text-yellow-400 text-sm font-bold tracking-[3px]">
            TIGREGYM
          </p>

          <h2 className="text-3xl font-black text-white mt-2">
            Cadastro de aluno
          </h2>

          <p className="text-zinc-500 mt-2">Preencha os dados do aluno.</p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Nome completo:
            </label>

            <input
              name="nome"
              value={aluno.nome}
              required
              onChange={(e) => handlerChange("nome", e.target.value)}
              placeholder="Digite o nome completo"
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              CPF:
            </label>

            <input
              name="cpf"
              value={aluno.cpf}
              required
              onChange={(e) => handlerChange("cpf", e.target.value)}
              placeholder="Digite o CPF"
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Data de nascimento:
            </label>

            <input
              name="dataNascimento"
              type="date"
              value={aluno.dataNascimento}
              required
              onChange={(e) => handlerChange("dataNascimento", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Telefone:
            </label>

            <input
              name="telefone"
              value={aluno.telefone}
              required
              onChange={(e) => handlerChange("telefone", e.target.value)}
              placeholder="Digite o telefone"
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>

          <div className="md:col-span-2">
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              E-mail:
            </label>

            <input
              name="email"
              type="email"
              value={aluno.email}
              required
              onChange={(e) => handlerChange("email", e.target.value)}
              placeholder="Digite o e-mail"
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>
        </div>

        <div className="flex justify-end gap-3 mt-8">
          <Link
            href="/aluno"
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
