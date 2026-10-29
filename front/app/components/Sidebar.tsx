"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";

function Icone({ tipo }: { tipo: string }) {
  const classe = "h-5 w-5";

  if (tipo === "home") {
    return (
      <svg className={classe} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
        <path d="M3 11.5 12 4l9 7.5" />
        <path d="M5.5 10.5V20h13v-9.5" />
        <path d="M9.5 20v-6h5v6" />
      </svg>
    );
  }

  if (tipo === "usuarios") {
    return (
      <svg className={classe} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
        <circle cx="9" cy="8" r="3" />
        <path d="M3.5 20c.4-4 2.3-6 5.5-6s5.1 2 5.5 6" />
        <path d="M16 6.5a2.5 2.5 0 0 1 0 5" />
        <path d="M17 14c2.2.7 3.3 2.5 3.5 5" />
      </svg>
    );
  }

  if (tipo === "alunos") {
    return (
      <svg className={classe} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
        <circle cx="12" cy="7" r="3" />
        <path d="M5 21c.5-5 2.8-7.5 7-7.5S18.5 16 19 21" />
        <path d="M4 4h4M16 4h4" />
      </svg>
    );
  }

  if (tipo === "matriculas") {
    return (
      <svg className={classe} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
        <rect x="5" y="4" width="14" height="16" rx="2" />
        <path d="M9 2v4M15 2v4M8 10h8M8 14h5" />
      </svg>
    );
  }

  return (
    <svg className={classe} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2">
      <rect x="4" y="6" width="16" height="12" rx="2" />
      <path d="M8 10h8M8 14h5" />
    </svg>
  );
}

export default function Sidebar() {
  const pathname = usePathname();

  const links = [
    { nome: "Home", href: "/home", icone: "home" },
    { nome: "Usuários", href: "/usuario", icone: "usuarios" },
    { nome: "Alunos", href: "/aluno", icone: "alunos" },
    { nome: "Matrículas", href: "/matricula", icone: "matriculas" },
    { nome: "Planos", href: "/plano", icone: "planos" },
  ];

  return (
    <aside className="sticky top-0 flex h-screen w-64 shrink-0 flex-col border-r border-zinc-800 bg-[#080b0d] px-4 py-6">
      <div className="px-3 pb-8">
        <h1 className="text-2xl font-black tracking-tight text-white">
          Tigre<span className="text-[#F5C518]">Gym</span>
        </h1>
        <p className="mt-1 text-xs text-zinc-600">Sistema de gestão</p>
      </div>

      <nav className="flex flex-1 flex-col gap-2">
        {links.map((link) => {
          const ativo = pathname.startsWith(link.href);

          return (
            <Link
              key={link.href}
              href={link.href}
              className={`flex items-center gap-3 rounded-lg px-4 py-3 text-sm font-semibold transition ${
                ativo
                  ? "bg-[#F5C518] text-black"
                  : "text-zinc-400 hover:bg-zinc-900 hover:text-white"
              }`}
            >
              <Icone tipo={link.icone} />
              {link.nome}
            </Link>
          );
        })}
      </nav>

    </aside>
  );
}
