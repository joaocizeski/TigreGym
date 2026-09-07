export default function NovoPlano(){
    return (

        <div className="min-h-screen w-full bg-black flex items-center justify-center p-8">

            <div className="w-full max-w-2xl bg-zinc-950 border border-zinc-800 rounded-2xl p-8">

                <div className="mb-8">

                    <h1 className="text-3xl font-bold text-white">
                        Cadastrar Plano
                    </h1>

                    <p className="text-zinc-400 mt-2">
                        Preencha os dados do novo plano
                    </p>

                </div>

                <form className="space-y-5">

                    <div>
                        <label className="text-zinc-300">
                            Nome
                        </label>

                        <input
                            name="nome"
                            placeholder="Digite o nome do plano"
                            className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
                        />
                    </div>

                    <div>
                        <label className="text-zinc-300">
                            Descrição
                        </label>

                        <textarea
                            name="descricao"
                            placeholder="Digite a descrição"
                            className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
                        />
                    </div>

                    <div>
                        <label className="text-zinc-300">
                            Valor
                        </label>

                        <input
                            name="valor"
                            placeholder="Digite o valor"
                            className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
                        />
                    </div>

                    <div>
                        <label className="text-zinc-300">
                            Duração em meses
                        </label>

                        <input
                            name="duracaoEmMeses"
                            placeholder="Digite a duração"
                            className="w-full mt-2 bg-zinc-900 border border-zinc-700 rounded-lg px-4 py-3 text-white"
                        />
                    </div>

                    <button
                        type="submit"
                        className="w-full bg-yellow-400 text-black font-semibold py-3 rounded-lg"
                    >
                        Cadastrar Plano
                    </button>

                </form>

            </div>

        </div>
    )
}