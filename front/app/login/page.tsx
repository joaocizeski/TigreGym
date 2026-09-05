'use client'
import { handler } from "next/dist/build/templates/app-route";
import { useRouter } from "next/navigation";

export default function Login(){
    const router = useRouter();

    const handleLogin = async(formData:FormData)=>{
        router.push("/home")
    }
    
    return(

        <div className="min-h-screen bg-black flex items-center justify-center px-4">
            <div className="w-full max-w-md bg-zinc-950 border border-zinc-800 rounded-2xl p-8 shadow-2xl">
                <div className="mb-8 text-center">
                    <h1 className="text-3xl font-bold text-white">
                        Entrar no sistema
                    </h1>

                    <p className="mt-2 text-sm text-zinc-400">
                        Acesse sua conta para continuar no TigreGym
                    </p>
                </div>

                <form action={handleLogin} className="space-y-5">
                    <div className="flex flex-col gap-2">
                        <label className="text-sm font-medium text-zinc-300">
                            E-mail
                        </label>

                        <input
                            name="email"
                            placeholder="Digite seu e-mail"
                            className="w-full rounded-lg border border-zinc-700 bg-zinc-900 px-4 py-3 text-white placeholder:text-zinc-500 outline-none transition focus:border-yellow-400 focus:ring-2 focus:ring-yellow-400/20"
                        />
                    </div>

                    <div className="flex flex-col gap-2">
                        <label className="text-sm font-medium text-zinc-300">
                            Senha
                        </label>

                        <input
                            name="senha"
                            placeholder="Digite sua senha"
                            className="w-full rounded-lg border border-zinc-700 bg-zinc-900 px-4 py-3 text-white placeholder:text-zinc-500 outline-none transition focus:border-yellow-400 focus:ring-2 focus:ring-yellow-400/20"
                        />
                    </div>

                    <button
                        type="submit"
                        className="w-full rounded-lg bg-yellow-400 py-3 font-semibold text-black transition hover:bg-yellow-300"
                    >
                        Entrar
                    </button>
                </form>
            </div>
        </div>

    );
}