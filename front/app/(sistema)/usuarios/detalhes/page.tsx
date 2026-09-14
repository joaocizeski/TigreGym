import Link from "next/link";

export default function DetalhesUsuario() {
  return (
    <div className="min-h-screen w-full bg-[#070707] text-white px-6 py-10 md:px-10">
      <div className="max-w-6xl mx-auto">
        <Link
          href="/usuarios"
          className="text-zinc-500 hover:text-[#F5C518] transition"
        >
          ← Voltar para usuários
        </Link>

        <div className="mt-7 mb-8">
          <p className="text-[#F5C518] text-sm font-bold tracking-[3px] mb-3">
            TIGREGYM
          </p>

          <h1 className="text-4xl md:text-5xl font-black">
            Detalhes do Usuário
          </h1>

          <p className="text-zinc-400 mt-3">
            Consulte as informações do usuário selecionado.
          </p>
        </div>

        <div className="bg-zinc-950 border border-zinc-800 rounded-2xl overflow-hidden">
          <div className="h-2 bg-[#F5C518]" />

          <div className="p-8">
            <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-8">
              <div className="flex flex-col sm:flex-row items-center sm:items-start gap-6">
                <img
                  src="https://i.pravatar.cc/300?img=12"
                  alt="João Silva"
                  className="w-32 h-32 rounded-full object-cover border-4 border-zinc-800"
                />

                <div className="text-center sm:text-left">
                  <div className="flex flex-col sm:flex-row sm:items-center gap-3">
                    <h2 className="text-3xl font-black">João Silva</h2>

                    <span className="bg-green-500/10 border border-green-500/20 text-green-400 px-3 py-1 rounded-full text-xs font-bold">
                      ● ATIVO
                    </span>
                  </div>

                  <p className="text-zinc-500 mt-2">
                    Usuário do sistema TigreGym
                  </p>

                  <p className="text-zinc-400 mt-5">joao@tigregym.com</p>

                  <p className="text-zinc-500 mt-1">000.000.000-00</p>
                </div>
              </div>

              <button className="bg-[#F5C518] hover:bg-yellow-300 text-black font-bold px-7 py-3 rounded-lg transition">
                Editar usuário
              </button>
            </div>
          </div>
        </div>

        <div className="grid grid-cols-1 lg:grid-cols-3 gap-6 mt-6">
          <div className="lg:col-span-2 bg-zinc-950 border border-zinc-800 rounded-2xl">
            <div className="border-b border-zinc-800 px-7 py-5">
              <h2 className="text-xl font-bold">Informações do usuário</h2>
            </div>

            <div className="grid grid-cols-1 md:grid-cols-2 gap-8 p-7">
              <div>
                <p className="text-zinc-500 text-sm">Nome completo</p>

                <p className="font-semibold text-lg mt-2">João Silva</p>
              </div>

              <div>
                <p className="text-zinc-500 text-sm">Status</p>

                <p className="text-green-400 font-semibold text-lg mt-2">
                  ATIVO
                </p>
              </div>

              <div>
                <p className="text-zinc-500 text-sm">E-mail</p>

                <p className="font-semibold text-lg mt-2">joao@tigregym.com</p>
              </div>

              <div>
                <p className="text-zinc-500 text-sm">CPF</p>

                <p className="font-semibold text-lg mt-2">000.000.000-00</p>
              </div>
            </div>
          </div>

          <div className="bg-zinc-950 border border-zinc-800 rounded-2xl p-6">
            <h2 className="text-xl font-bold mb-6">Resumo</h2>

            <div className="space-y-5">
              <div>
                <p className="text-zinc-500 text-sm">Situação</p>

                <p className="text-green-400 font-semibold mt-1">
                  Usuário ativo
                </p>
              </div>

              <div className="border-t border-zinc-800 pt-5">
                <p className="text-zinc-500 text-sm">Acesso</p>

                <p className="font-semibold mt-1">Sistema TigreGym</p>
              </div>

              <div className="border-t border-zinc-800 pt-5">
                <p className="text-zinc-500 text-sm">Cadastro</p>

                <p className="font-semibold mt-1">01/01/2026</p>
              </div>
            </div>
          </div>
        </div>

        <div className="flex flex-col sm:flex-row gap-3 mt-6">
          <button className="bg-zinc-950 border border-zinc-800 hover:bg-zinc-900 px-6 py-3 rounded-lg font-semibold transition">
            Bloquear usuário
          </button>

          <button className="bg-red-500/10 border border-red-500/20 hover:bg-red-500/20 text-red-400 px-6 py-3 rounded-lg font-semibold transition">
            Excluir usuário
          </button>
        </div>
      </div>
    </div>
  );
}
