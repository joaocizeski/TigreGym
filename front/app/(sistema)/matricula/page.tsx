import Link from "next/link";

export default function Matricula(){
    return (

        <div className="min-h-screen w-full bg-[#070707] text-white px-6 py-10 md:px-10">

            <div className="max-w-7xl mx-auto">


                <div className="flex flex-col md:flex-row md:items-end md:justify-between gap-5 mb-10">

                    <div>

                        <p className="text-[#F5C518] text-sm font-bold tracking-[3px] mb-3">
                            TIGREGYM
                        </p>

                        <h1 className="text-4xl md:text-5xl font-black">
                            Matrículas
                        </h1>

                        <p className="text-zinc-400 mt-3">
                            Acompanhe e gerencie as matrículas dos alunos.
                        </p>

                    </div>


                    <Link
                        href="/matricula/novo"
                        className="bg-[#F5C518] hover:bg-yellow-300 text-black font-bold px-6 py-3 rounded-lg transition"
                    >
                        + Nova Matrícula
                    </Link>

                </div>



                <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4 mb-8">


                    <div className="bg-zinc-950 border border-zinc-800 rounded-xl p-5">

                        <p className="text-zinc-500 text-sm">
                            Total de matrículas
                        </p>

                        <p className="text-3xl font-black mt-2">
                            124
                        </p>

                    </div>


                    <div className="bg-zinc-950 border border-zinc-800 rounded-xl p-5">

                        <p className="text-zinc-500 text-sm">
                            Ativas
                        </p>

                        <p className="text-3xl font-black text-green-400 mt-2">
                            98
                        </p>

                    </div>


                    <div className="bg-zinc-950 border border-zinc-800 rounded-xl p-5">

                        <p className="text-zinc-500 text-sm">
                            Bloqueadas
                        </p>

                        <p className="text-3xl font-black text-red-400 mt-2">
                            14
                        </p>

                    </div>


                    <div className="bg-zinc-950 border border-yellow-400/30 rounded-xl p-5">

                        <p className="text-zinc-500 text-sm">
                            Vencem em breve
                        </p>

                        <p className="text-3xl font-black text-[#F5C518] mt-2">
                            12
                        </p>

                    </div>


                </div>



                <div className="flex flex-col md:flex-row gap-4 mb-6">

                    <input
                        type="text"
                        placeholder="Pesquisar aluno..."
                        className="flex-1 bg-zinc-950 border border-zinc-800 rounded-lg px-4 py-3 text-white placeholder:text-zinc-600 outline-none focus:border-[#F5C518]"
                    />


                    <button className="bg-[#F5C518] text-black font-bold px-6 py-3 rounded-lg">
                        Todas
                    </button>

                    <button className="bg-zinc-950 border border-zinc-800 px-6 py-3 rounded-lg">
                        Ativas
                    </button>

                    <button className="bg-zinc-950 border border-zinc-800 px-6 py-3 rounded-lg">
                        Bloqueadas
                    </button>

                </div>



                <div className="bg-zinc-950 border border-zinc-800 rounded-2xl overflow-x-auto">


                    <table className="w-full text-left min-w-[900px]">


                        <thead className="bg-zinc-900/80">

                            <tr className="text-zinc-400 text-sm">

                                <th className="p-5">
                                    Aluno
                                </th>

                                <th className="p-5">
                                    Plano
                                </th>

                                <th className="p-5">
                                    Início
                                </th>

                                <th className="p-5">
                                    Vencimento
                                </th>

                                <th className="p-5">
                                    Status
                                </th>

                                <th className="p-5">
                                    Ações
                                </th>

                            </tr>

                        </thead>



                        <tbody>


                            <tr className="border-t border-zinc-800 hover:bg-zinc-900/40">

                                <td className="p-5 font-semibold">
                                    João da Silva
                                </td>

                                <td className="p-5 text-zinc-400">
                                    Premium
                                </td>

                                <td className="p-5 text-zinc-400">
                                    01/09/2026
                                </td>

                                <td className="p-5 text-zinc-400">
                                    01/10/2026
                                </td>

                                <td className="p-5">

                                    <span className="bg-green-500/10 border border-green-500/20 text-green-400 px-3 py-1 rounded-full text-xs font-bold">
                                        ATIVO
                                    </span>

                                </td>

                                <td className="p-5">

                                    <div className="flex gap-4">

                                        <button className="text-yellow-400">
                                            Editar
                                        </button>

                                        <button className="text-red-400">
                                            Excluir
                                        </button>

                                    </div>

                                </td>

                            </tr>



                            <tr className="border-t border-zinc-800 hover:bg-zinc-900/40">

                                <td className="p-5 font-semibold">
                                    Maria Oliveira
                                </td>

                                <td className="p-5 text-zinc-400">
                                    Basic
                                </td>

                                <td className="p-5 text-zinc-400">
                                    15/08/2026
                                </td>

                                <td className="p-5 text-yellow-400">
                                    15/09/2026
                                </td>

                                <td className="p-5">

                                    <span className="bg-green-500/10 border border-green-500/20 text-green-400 px-3 py-1 rounded-full text-xs font-bold">
                                        ATIVO
                                    </span>

                                </td>

                                <td className="p-5">

                                    <div className="flex gap-4">

                                        <button className="text-yellow-400">
                                            Editar
                                        </button>

                                        <button className="text-red-400">
                                            Excluir
                                        </button>

                                    </div>

                                </td>

                            </tr>



                            <tr className="border-t border-zinc-800 hover:bg-zinc-900/40">

                                <td className="p-5 font-semibold">
                                    Carlos Souza
                                </td>

                                <td className="p-5 text-zinc-400">
                                    Anual
                                </td>

                                <td className="p-5 text-zinc-400">
                                    10/01/2026
                                </td>

                                <td className="p-5 text-zinc-400">
                                    10/01/2027
                                </td>

                                <td className="p-5">

                                    <span className="bg-red-500/10 border border-red-500/20 text-red-400 px-3 py-1 rounded-full text-xs font-bold">
                                        BLOQUEADO
                                    </span>

                                </td>

                                <td className="p-5">

                                    <div className="flex gap-4">

                                        <button className="text-yellow-400">
                                            Editar
                                        </button>

                                        <button className="text-red-400">
                                            Excluir
                                        </button>

                                    </div>

                                </td>

                            </tr>


                        </tbody>


                    </table>

                </div>


            </div>

        </div>

    )
}