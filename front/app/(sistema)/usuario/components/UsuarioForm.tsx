"use client";

import Link from "next/link";
import { useState } from "react";
import { Usuario, UsuarioFormProps } from "../usuario";
import { useRouter } from "next/navigation";
import axios from "axios";

export default function UsuarioForm({ usuarioExistente }: UsuarioFormProps) {
  const router = useRouter();

  // Usa os dados existentes quando for edição
  const [usuario, setUsuario] = useState<Usuario>(
    usuarioExistente || new Usuario(null, "", "", "ATIVO", "", "")
  );

  // Muda somente o campo que foi digitado
  const handlerChange = (
    campo: "nome" | "email" | "cpf" | "senha",
    valor: string
  ) => {
    setUsuario(
      (valorAnterior) =>
        new Usuario(
          valorAnterior.id,
          campo === "nome" ? valor : valorAnterior.nome,
          campo === "email" ? valor : valorAnterior.email,
          valorAnterior.status,
          campo === "cpf" ? valor : valorAnterior.cpf,
          campo === "senha" ? valor : valorAnterior.senha
        )
    );
  };

  const handlerSalvar = async (formData: FormData) => {
    // Se o usuário já existe, edita ele
    if (usuarioExistente) {
      var dadosRetorno = await axios.put(
        "http://localhost:8080/usuarios/" + usuario.id,
        usuario
      );

      if (dadosRetorno.status == 200) {
        alert("Usuário foi salvo com sucesso!");
      } else {
        alert(dadosRetorno.data);
        return;
      }
    } else {
      // Se não existe, cria um novo
      var dadosRetorno = await axios.post(
        "http://localhost:8080/usuarios",
        usuario
      );

      if (dadosRetorno.status == 200) {
        alert("Usuário foi salvo com sucesso!");
      } else {
        alert(dadosRetorno.data);
        return;
      }
    }

    router.push("/usuario");
  };

  return (
    <form action={handlerSalvar} className="w-full">
      <div className="bg-zinc-950 border border-zinc-800 rounded-2xl p-8 shadow-2xl">
        <div className="mb-8">
          <p className="text-yellow-400 text-sm font-bold tracking-[3px]">
            TIGREGYM
          </p>

          <h2 className="text-3xl font-black text-white mt-2">
            Cadastro de usuário
          </h2>

          <p className="text-zinc-500 mt-2">Preencha os dados do usuário.</p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Nome completo:
            </label>

            <input
              name="nome"
              value={usuario.nome}
              required
              onChange={(e) => handlerChange("nome", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite o nome completo"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              CPF:
            </label>

            <input
              name="cpf"
              value={usuario.cpf}
              required
              onChange={(e) => handlerChange("cpf", e.target.value)}
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite o CPF"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              E-mail:
            </label>

            <input
              name="email"
              value={usuario.email}
              required
              onChange={(e) => handlerChange("email", e.target.value)}
              type="email"
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite o e-mail"
            />
          </div>

          <div>
            <label className="block text-sm font-semibold text-zinc-300 mb-2">
              Senha:
            </label>

            <input
              name="senha"
              value={usuario.senha}
              required
              onChange={(e) => handlerChange("senha", e.target.value)}
              type="password"
              className="w-full bg-zinc-900 border border-zinc-800 rounded-lg px-4 py-3 text-white outline-none focus:border-yellow-400 transition"
              placeholder="Digite a senha"
            />
          </div>
        </div>

        <div className="flex justify-end gap-3 mt-8">
          <Link
            href="/usuario"
            className="px-5 py-3 rounded-lg border border-zinc-700 text-zinc-300 hover:bg-zinc-900 transition"
          >
            Cancelar
          </Link>

          <button
            type="submit"
            className="px-6 py-3 rounded-lg bg-yellow-400 text-black font-bold hover:bg-yellow-300 transition"
          >
            Salvar
          </button>
        </div>
      </div>
    </form>
  );
}
