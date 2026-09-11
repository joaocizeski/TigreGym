import Link from "next/link";

export default function Planos(){
    return (

        <div className="min-h-screen w-full bg-[#070707] text-white px-6 py-10 md:px-10">

            <div className="max-w-7xl mx-auto">


                <div className="flex flex-col md:flex-row md:items-end md:justify-between gap-5 mb-10">

                    <div>

                        <p className="text-[#F5C518] text-sm font-bold tracking-[3px] mb-3">
                            TIGREGYM
                        </p>

                        <h1 className="text-4xl md:text-5xl font-black">
                            Planos
                        </h1>

                        <p className="text-zinc-400 mt-3">
                            Gerencie os planos disponíveis na academia.
                        </p>

                    </div>


                    <Link
                        href="/plano/novo"
                        className="bg-[#F5C518] hover:bg-yellow-300 text-black font-bold px-6 py-3 rounded-lg transition"
                    >
                        + Novo Plano
                    </Link>

                </div>


                <div className="mb-8">

                    <input
                        type="text"
                        placeholder="Pesquisar plano..."
                        className="w-full md:w-96 bg-zinc-950 border border-zinc-800 rounded-lg px-4 py-3 text-white placeholder:text-zinc-600 outline-none focus:border-[#F5C518]"
                    />

                </div>


                <div className="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-6">


                    <div className="bg-zinc-950 border border-zinc-800 rounded-2xl p-7 hover:border-zinc-700 transition">

                        <div className="flex items-start justify-between">

                            <div className="w-12 h-12 bg-zinc-900 rounded-xl flex items-center justify-center text-2xl">
                                🏋️
                            </div>

                            <span className="bg-green-500/10 text-green-400 border border-green-500/20 px-3 py-1 rounded-full text-xs font-bold">
                                ATIVO
                            </span>

                        </div>


                        <div className="mt-7">

                            <p className="text-xs text-zinc-500 font-bold tracking-widest">
                                PLANO
                            </p>

                            <h2 className="text-2xl font-bold mt-2">
                                Plano Basic
                            </h2>

                            <p className="text-zinc-400 mt-3 min-h-12">
                                Acesso à academia para quem busca simplicidade.
                            </p>

                        </div>


                        <div className="border-t border-zinc-800 mt-6 pt-6">

                            <span className="text-4xl font-black text-[#F5C518]">
                                R$ 79,90
                            </span>

                            <span className="text-zinc-500">
                                {" "}/ mês
                            </span>

                        </div>


                        <div className="flex items-center justify-between mt-6 text-sm">

                            <span className="text-zinc-500">
                                Duração
                            </span>

                            <span className="font-semibold">
                                1 mês
                            </span>

                        </div>


                        <div className="grid grid-cols-2 gap-3 mt-7">

                            <button className="bg-zinc-900 hover:bg-zinc-800 border border-zinc-800 py-3 rounded-lg font-semibold">
                                Editar
                            </button>

                            <button className="bg-red-500/10 hover:bg-red-500/20 border border-red-500/20 text-red-400 py-3 rounded-lg font-semibold">
                                Excluir
                            </button>

                        </div>

                    </div>



                    <div className="relative bg-zinc-950 border-2 border-[#F5C518] rounded-2xl p-7 shadow-[0_0_50px_rgba(245,197,24,0.08)]">

                        <div className="absolute top-0 right-7 -translate-y-1/2 bg-[#F5C518] text-black text-xs font-black px-4 py-2 rounded-full">
                            MAIS POPULAR
                        </div>


                        <div className="flex items-start justify-between">

                            <div className="w-12 h-12 bg-yellow-400/10 rounded-xl flex items-center justify-center text-2xl">
                                👑
                            </div>

                            <span className="bg-green-500/10 text-green-400 border border-green-500/20 px-3 py-1 rounded-full text-xs font-bold">
                                ATIVO
                            </span>

                        </div>


                        <div className="mt-7">

                            <p className="text-xs text-yellow-400 font-bold tracking-widest">
                                PLANO
                            </p>

                            <h2 className="text-2xl font-bold mt-2">
                                Plano Premium
                            </h2>

                            <p className="text-zinc-400 mt-3 min-h-12">
                                Um plano completo para aproveitar mais a academia.
                            </p>

                        </div>


                        <div className="border-t border-zinc-800 mt-6 pt-6">

                            <span className="text-4xl font-black text-[#F5C518]">
                                R$ 129,90
                            </span>

                            <span className="text-zinc-500">
                                {" "}/ mês
                            </span>

                        </div>


                        <div className="flex items-center justify-between mt-6 text-sm">

                            <span className="text-zinc-500">
                                Duração
                            </span>

                            <span className="font-semibold">
                                1 mês
                            </span>

                        </div>


                        <div className="grid grid-cols-2 gap-3 mt-7">

                            <button className="bg-zinc-900 hover:bg-zinc-800 border border-zinc-800 py-3 rounded-lg font-semibold">
                                Editar
                            </button>

                            <button className="bg-red-500/10 hover:bg-red-500/20 border border-red-500/20 text-red-400 py-3 rounded-lg font-semibold">
                                Excluir
                            </button>

                        </div>

                    </div>



                    <div className="bg-zinc-950 border border-zinc-800 rounded-2xl p-7 hover:border-zinc-700 transition">

                        <div className="flex items-start justify-between">

                            <div className="w-12 h-12 bg-zinc-900 rounded-xl flex items-center justify-center text-2xl">
                                📅
                            </div>

                            <span className="bg-green-500/10 text-green-400 border border-green-500/20 px-3 py-1 rounded-full text-xs font-bold">
                                ATIVO
                            </span>

                        </div>


                        <div className="mt-7">

                            <p className="text-xs text-zinc-500 font-bold tracking-widest">
                                PLANO
                            </p>

                            <h2 className="text-2xl font-bold mt-2">
                                Plano Anual
                            </h2>

                            <p className="text-zinc-400 mt-3 min-h-12">
                                Plano para quem quer manter o foco durante todo o ano.
                            </p>

                        </div>


                        <div className="border-t border-zinc-800 mt-6 pt-6">

                            <span className="text-4xl font-black text-[#F5C518]">
                                R$ 999,00
                            </span>

                            <span className="text-zinc-500">
                                {" "}/ ano
                            </span>

                        </div>


                        <div className="flex items-center justify-between mt-6 text-sm">

                            <span className="text-zinc-500">
                                Duração
                            </span>

                            <span className="font-semibold">
                                12 meses
                            </span>

                        </div>


                        <div className="grid grid-cols-2 gap-3 mt-7">

                            <button className="bg-zinc-900 hover:bg-zinc-800 border border-zinc-800 py-3 rounded-lg font-semibold">
                                Editar
                            </button>

                            <button className="bg-red-500/10 hover:bg-red-500/20 border border-red-500/20 text-red-400 py-3 rounded-lg font-semibold">
                                Excluir
                            </button>

                        </div>

                    </div>


                </div>

            </div>

        </div>

    )
}