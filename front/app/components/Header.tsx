export default function Header() {
  return (
    <>
      <header className="w-full border-b border-zinc-800 bg-zinc-950 px-6 py-3">
        <div className="mx-auto flex max-w-7xl items-center justify-between">
          <div className="flex items-center">
            <img
              src="/logo-tigregym-v2.png"
              alt="Logo TigreGym"
              className="h-14 w-auto object-contain"
            />
          </div>

          <div className="flex items-center gap-5">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center rounded-full bg-yellow-400 text-black">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  strokeWidth="2"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  className="h-5 w-5"
                >
                  <path d="M20 21a8 8 0 0 0-16 0" />
                  <circle cx="12" cy="7" r="4" />
                </svg>
              </div>

              <span className="hidden text-sm font-medium text-white sm:block md:text-base">
                Usuario João Vitor
              </span>
            </div>

            <div>
              <button className="rounded-lg border border-yellow-400 px-4 py-2 text-sm font-semibold text-yellow-400 transition duration-200 hover:bg-yellow-400 hover:text-black">
                Sair
              </button>
            </div>
          </div>
        </div>
      </header>
    </>
  );
}
