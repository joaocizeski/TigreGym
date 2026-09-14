export default function NovoUsuario() {
  return (
    <div className="min-h-screen w-full bg-black flex items-center justify-center p-8">
      <div className="w-full max-w-2xl bg-zinc-950 border border-zinc-800 rounded-2xl p-8">
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-white">Cadastrar Usuário</h1>

          <p className="text-zinc-400 mt-2">
            Preencha os dados do novo usuário
          </p>
        </div>

        <form className="space-y-5">
          <div>
            <label className="text-zinc-300">Nome</label>

            <input
              name="nome"
              placeholder="Digite o nome"
              className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
            />
          </div>

          <div>
            <label className="text-zinc-300">CPF</label>

            <input
              name="cpf"
              placeholder="Digite o CPF"
              className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
            />
          </div>

          <div>
            <label className="text-zinc-300">E-mail</label>

            <input
              name="email"
              type="email"
              placeholder="Digite o e-mail"
              className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
            />
          </div>

          <div>
            <label className="text-zinc-300">Senha</label>

            <input
              name="senha"
              type="password"
              placeholder="Digite a senha"
              className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
            />
          </div>

          <button
            type="submit"
            className="w-full bg-yellow-400 text-black font-semibold py-3 rounded-lg"
          >
            Cadastrar Usuário
          </button>
        </form>
      </div>
    </div>
  );
}
