"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";

export default function Sidebar() {
  const pathname = usePathname();

  const links = [
    { nome: "Home", href: "/home" },
    { nome: "Usuários", href: "/usuario" },
    { nome: "Alunos", href: "/aluno" },
    { nome: "Matrículas", href: "/matricula" },
    { nome: "Planos", href: "/plano" },
  ];

  return (
    <aside className="w-64 min-h-screen bg-black border-r border-zinc-900 px-5 py-8">
      <div className="px-3 mb-10">
        <h1 className="text-2xl font-black text-white">
          Tigre<span className="text-yellow-400">Gym</span>
        </h1>

        <p className="text-xs text-zinc-600 mt-1">
          Sistema de gestão
        </p>
      </div>

      <nav className="flex flex-col gap-2">
        {links.map((link) => {
          const ativo = pathname.startsWith(link.href);

          return (
            <Link
              key={link.href}
              href={link.href}
              className={`px-4 py-3 rounded-lg text-sm font-medium transition ${
                ativo
                  ? "bg-zinc-900 text-yellow-400"
                  : "text-zinc-400 hover:bg-zinc-900 hover:text-white"
              }`}
            >
              {link.nome}
            </Link>
          );
        })}
      </nav>
    </aside>
  );
}