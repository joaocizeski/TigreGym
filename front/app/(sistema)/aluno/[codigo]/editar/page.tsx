"use client";

import Link from "next/link";
import { useParams } from "next/navigation";
import AlunoForm from "../../components/AlunoForm";

export default function EditarAluno() {
  const parametro = useParams();

  const codigo = Number(parametro.codigo);

  return (
    <div className="w-full bg-black px-6 py-10 md:px-10">
      <div className="max-w-4xl mx-auto">

        <div className="mb-10">

          <Link
            href="/aluno"
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
              Editar Aluno {codigo}
            </h1>

            <p className="text-zinc-500 mt-3">
              Preencha os dados para editar o aluno.
            </p>
          </div>

        </div>

        <AlunoForm />

      </div>
    </div>
  );
}