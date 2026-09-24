import Link from "next/link";

export default function AlunoForm() {
  return (
    <form className="w-full">
      <div className="bg-zinc-950 border border-zinc-800 rounded-2xl p-8 shadow-2xl">
        <div className="mb-8">
          <p className="text-yellow-400 text-sm font-bold tracking-[3px]">
            TIGREGYM
          </p>

          <h2 className="text-3xl font-black text-white mt-2">
            Cadastro de aluno
          </h2>

          <p className="text-zinc-500 mt-2">
            Preencha os dados do aluno.
          </p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-5">

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Nome completo:
            </label>

            <input
              name="nome"
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
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Telefone:
            </label>

            <input
              name="telefone"
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