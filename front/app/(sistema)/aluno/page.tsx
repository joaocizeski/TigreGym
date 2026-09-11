import Link from "next/link";

export default function Aluno(){
    return (

        <div className="min-h-screen w-full bg-[#070707] text-white px-6 py-10 md:px-10">

            <div className="max-w-7xl mx-auto">


                <div className="flex flex-col md:flex-row md:items-end md:justify-between gap-5 mb-10">

                    <div>

                        <p className="text-[#F5C518] text-sm font-bold tracking-[3px] mb-3">
                            TIGREGYM
                        </p>

                        <h1 className="text-4xl md:text-5xl font-black">
                            Alunos
                        </h1>

                        <p className="text-zinc-400 mt-3">
                            Gerencie os alunos cadastrados na academia.
                        </p>

                    </div>


                    <Link
                        href="/aluno/novo"
                        className="bg-[#F5C518] hover:bg-yellow-300 text-black font-bold px-6 py-3 rounded-lg transition"
                    >
                        + Novo Aluno
                    </Link>

                </div>


                <div className="grid grid-cols-1 md:grid-cols-3 gap-4 mb-8">

                    <div className="bg-zinc-950 border border-zinc-800 rounded-xl p-5">

                        <p className="text-zinc-500 text-sm">
                            Total de alunos
                        </p>

                        <p className="text-3xl font-black mt-2">
                            84
                        </p>

                    </div>


                    <div className="bg-zinc-950 border border-zinc-800 rounded-xl p-5">

                        <p className="text-zinc-500 text-sm">
                            Alunos ativos
                        </p>

                        <p className="text-3xl font-black text-green-400 mt-2">
                            76
                        </p>

                    </div>


                    <div className="bg-zinc-950 border border-zinc-800 rounded-xl p-5">

                        <p className="text-zinc-500 text-sm">
                            Bloqueados
                        </p>

                        <p className="text-3xl font-black text-red-400 mt-2">
                            8
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
                        Todos
                    </button>

                    <button className="bg-zinc-950 border border-zinc-800 px-6 py-3 rounded-lg">
                        Ativos
                    </button>

                    <button className="bg-zinc-950 border border-zinc-800 px-6 py-3 rounded-lg">
                        Bloqueados
                    </button>

                </div>


                <div className="bg-zinc-950 border border-zinc-800 rounded-2xl overflow-x-auto">

                    <table className="w-full text-left min-w-[1000px]">


                        <thead className="bg-zinc-900/80">

                            <tr className="text-zinc-400 text-sm">

                                <th className="p-5">
                                    Nome
                                </th>

                                <th className="p-5">
                                    CPF
                                </th>

                                <th className="p-5">
                                    Nascimento
                                </th>

                                <th className="p-5">
                                    Telefone
                                </th>

                                <th className="p-5">
                                    E-mail
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
                                    000.000.000-00
                                </td>

                                <td className="p-5 text-zinc-400">
                                    01/01/2000
                                </td>

                                <td className="p-5 text-zinc-400">
                                    (48) 99999-9999
                                </td>

                                <td className="p-5 text-zinc-400">
                                    joao@email.com
                                </td>

                                <td className="p-5">

                                    <span className="bg-green-500/10 border border-green-500/20 text-green-400 px-3 py-1 rounded-full text-xs font-bold">
                                        ATIVO
                                    </span>

                                </td>

                                <td className="p-5">

                                    <div className="flex gap-4">

                                        <button className="text-yellow-400 hover:text-yellow-300">
                                            Editar
                                        </button>

                                        <button className="text-red-400 hover:text-red-300">
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
                                    111.111.111-11
                                </td>

                                <td className="p-5 text-zinc-400">
                                    12/05/1998
                                </td>

                                <td className="p-5 text-zinc-400">
                                    (48) 98888-8888
                                </td>

                                <td className="p-5 text-zinc-400">
                                    maria@email.com
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
                                    222.222.222-22
                                </td>

                                <td className="p-5 text-zinc-400">
                                    25/10/2001
                                </td>

                                <td className="p-5 text-zinc-400">
                                    (48) 97777-7777
                                </td>

                                <td className="p-5 text-zinc-400">
                                    carlos@email.com
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