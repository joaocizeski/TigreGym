import Link from "next/link";

export default function Usuarios(){
    return (

        <div className="min-h-screen w-full bg-black p-8">

            <div className="flex items-center justify-between mb-8">

                <div>
                    <h1 className="text-3xl font-bold text-white">
                        Gestão de Usuários
                    </h1>

                    <p className="text-zinc-400 mt-2">
                        Consulte e gerencie os usuários do sistema
                    </p>
                </div>

                <Link
                    href="/usuarios/novo"
                    className="bg-yellow-400 text-black font-semibold px-5 py-3 rounded-lg"
                >
                    Novo Usuário
                </Link>

            </div>

            <div className="bg-zinc-950 border border-zinc-800 rounded-xl overflow-hidden">

                <table className="w-full text-left">

                    <thead className="bg-zinc-900 text-zinc-300">

                        <tr>
                            <th className="p-4">Nome</th>
                            <th className="p-4">CPF</th>
                            <th className="p-4">E-mail</th>
                            <th className="p-4">Status</th>
                            <th className="p-4">Ações</th>
                        </tr>

                    </thead>

                    <tbody className="text-white">

                        <tr className="border-t border-zinc-800">

                            <td className="p-4">João</td>
                            <td className="p-4">000.000.000-00</td>
                            <td className="p-4">joao@email.com</td>
                            <td className="p-4">ATIVO</td>

                            <td className="p-4">

                                <div className="flex gap-3">

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
    )
}