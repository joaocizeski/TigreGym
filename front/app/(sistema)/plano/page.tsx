import Link from "next/link";

export default function Planos(){
    return (

        <div className="min-h-screen w-full bg-black p-8">

            <div className="flex items-center justify-between mb-8">

                <div>
                    <h1 className="text-3xl font-bold text-white">
                        Gestão de Planos
                    </h1>

                    <p className="text-zinc-400 mt-2">
                        Consulte e gerencie os planos da academia
                    </p>
                </div>

                <Link
                    href="/plano/novo"
                    className="bg-yellow-400 text-black font-semibold px-5 py-3 rounded-lg"
                >
                    Novo Plano
                </Link>

            </div>

            <div className="bg-zinc-950 border border-zinc-800 rounded-xl overflow-hidden">

                <table className="w-full text-left">

                    <thead className="bg-zinc-900 text-zinc-300">
                        <tr>
                            <th className="p-4">Nome</th>
                            <th className="p-4">Descrição</th>
                            <th className="p-4">Valor</th>
                            <th className="p-4">Duração</th>
                            <th className="p-4">Status</th>
                            <th className="p-4">Ações</th>
                        </tr>
                    </thead>

                    <tbody className="text-white">

                        <tr className="border-t border-zinc-800">

                            <td className="p-4">Plano Mensal</td>
                            <td className="p-4">Acesso completo à academia</td>
                            <td className="p-4">R$ 99,90</td>
                            <td className="p-4">1 mês</td>
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