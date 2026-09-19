export default function Footer() {
  const anoAtual = new Date().getFullYear();

  return (
    <footer className="border-t border-zinc-800 bg-black px-6 py-4">
      <div className="mx-auto flex max-w-7xl items-center justify-center">
        <div>
          <p className="text-center text-sm text-zinc-500">
            &copy; {anoAtual}
            <span className="mx-1 font-semibold text-yellow-400">TigreGym</span>
            Todos os direitos reservados.
          </p>
        </div>
      </div>
    </footer>
  );
}
