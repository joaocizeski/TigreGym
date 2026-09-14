export default function NovaMatricula() {
  return (
    <div className="min-h-screen w-full bg-black flex items-center justify-center p-8">
      <div className="w-full max-w-2xl bg-zinc-950 border border-zinc-800 rounded-2xl p-8">
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-white">Nova Matrícula</h1>

          <p className="text-zinc-400 mt-2">Preencha os dados da matrícula</p>
        </div>

        <form className="space-y-5">
          <div>
            <label className="text-zinc-300">Aluno</label>

            <input
              name="aluno"
              placeholder="Digite o aluno"
              className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
            />
          </div>

          <div>
            <label className="text-zinc-300">Plano</label>

            <input
              name="plano"
              placeholder="Digite o plano"
              className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
            />
          </div>

          <div>
            <label className="text-zinc-300">Data de início</label>

            <input
              name="dataInicio"
              type="datetime-local"
              className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
            />
          </div>

          <div>
            <label className="text-zinc-300">Data de vencimento</label>

            <input
              name="dataVencimento"
              type="datetime-local"
              className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
            />
          </div>

          <button
            type="submit"
            className="w-full bg-yellow-400 text-black font-semibold py-3 rounded-lg"
          >
            Cadastrar Matrícula
          </button>
        </form>
      </div>
    </div>
  );
}
