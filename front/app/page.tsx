import Link from "next/link";

export default function Home() {
  return (
    <>
      <style>{`
        :root {
          --black: #080808;
          --black-light: #111111;
          --white: #ffffff;
          --gray: #a6a6a6;
          --yellow: #f5c518;
          --yellow-light: #ffda44;
        }

        * {
          margin: 0;
          padding: 0;
          box-sizing: border-box;
        }

        html,
        body {
          min-height: 100%;
        }

        body {
          font-family: Arial, Helvetica, sans-serif;
          background: var(--black);
          color: var(--white);
        }

        a {
          text-decoration: none;
        }

        .page {
          min-height: 100vh;
          display: flex;
          flex-direction: column;
          position: relative;
          overflow: hidden;

          background:
            radial-gradient(
              circle at 85% 45%,
              rgba(245, 197, 24, 0.12),
              transparent 28%
            ),
            var(--black);
        }

        /* HEADER */

        .header {
          width: 100%;
          height: 84px;

          display: flex;
          align-items: center;

          border-bottom: 1px solid rgba(255, 255, 255, 0.07);

          position: relative;
          z-index: 10;
        }

        .container {
          width: min(1180px, 90%);
          margin: 0 auto;
        }

        .navbar {
          display: flex;
          align-items: center;
          justify-content: space-between;
        }

        /* LOGO */

        .brand {
          display: flex;
          align-items: center;
          gap: 12px;
        }

        .brand-logo {
          width: 52px;
          height: 58px;
        }

        .brand-name {
          color: var(--white);

          font-size: 1.48rem;
          font-weight: 900;

          letter-spacing: -1.2px;
        }

        .brand-name span {
          color: var(--yellow);
        }

        /* LOGIN */

        .login-button {
          background: var(--yellow);
          color: var(--black);

          padding: 11px 25px;

          border-radius: 8px;

          font-size: 0.94rem;
          font-weight: 700;

          transition:
            transform 0.2s ease,
            background 0.2s ease;
        }

        .login-button:hover {
          background: var(--yellow-light);
          transform: translateY(-2px);
        }

        /* MAIN */

        .main {
          flex: 1;

          display: flex;
          align-items: center;

          padding: 70px 0;
        }

        .hero {
          display: grid;

          grid-template-columns: 1.05fr 0.95fr;

          align-items: center;

          gap: 90px;
        }

        /* TEXTO PRINCIPAL */

        .hero-text {
          max-width: 650px;
        }

        .hero h1 {
          font-size: clamp(3.7rem, 6.5vw, 6rem);

          line-height: 0.95;

          letter-spacing: -5px;

          margin-bottom: 28px;
        }

        .hero h1 span {
          color: var(--yellow);
        }

        .hero-description {
          max-width: 590px;

          color: var(--gray);

          font-size: 1.08rem;
          line-height: 1.75;

          margin-bottom: 36px;
        }

        .buttons {
          display: flex;
          align-items: center;

          gap: 16px;

          flex-wrap: wrap;
        }

        .primary-button {
          display: inline-flex;
          align-items: center;
          justify-content: center;

          gap: 10px;

          padding: 15px 27px;

          background: var(--yellow);
          color: var(--black);

          border-radius: 9px;

          font-size: 0.95rem;
          font-weight: 700;

          transition:
            transform 0.2s ease,
            background 0.2s ease;
        }

        .primary-button:hover {
          background: var(--yellow-light);
          transform: translateY(-2px);
        }

        .button-arrow {
          font-size: 1.1rem;
        }

        /* LADO DIREITO */

        .visual {
          display: flex;
          align-items: center;
          justify-content: center;

          position: relative;

          min-height: 470px;
        }

        .visual-glow {
          position: absolute;

          width: 330px;
          height: 330px;

          border-radius: 50%;

          background: rgba(245, 197, 24, 0.12);

          filter: blur(80px);
        }

        .panel {
          width: 100%;
          max-width: 460px;

          position: relative;
          z-index: 2;

          padding: 24px;

          border: 1px solid rgba(255, 255, 255, 0.08);

          background: rgba(17, 17, 17, 0.85);

          backdrop-filter: blur(20px);

          border-radius: 22px;

          box-shadow: 0 35px 80px rgba(0, 0, 0, 0.4);
        }

        .panel-header {
          display: flex;
          align-items: center;
          justify-content: space-between;

          margin-bottom: 26px;
        }

        .panel-title {
          display: flex;
          align-items: center;

          gap: 11px;
        }

        .small-logo {
          width: 39px;
          height: 44px;
        }

        .panel-title strong {
          display: block;

          color: var(--white);

          font-size: 0.95rem;
        }

        .panel-title span {
          display: block;

          color: #717171;

          font-size: 0.74rem;

          margin-top: 2px;
        }

        .status {
          display: flex;
          align-items: center;

          gap: 7px;

          color: #a9a9a9;

          font-size: 0.72rem;
        }

        .status-dot {
          width: 7px;
          height: 7px;

          background: var(--yellow);

          border-radius: 50%;
        }

        .welcome-card {
          padding: 24px;

          border-radius: 16px;

          background:
            linear-gradient(
              125deg,
              rgba(245, 197, 24, 0.18),
              rgba(245, 197, 24, 0.04)
            );

          border: 1px solid rgba(245, 197, 24, 0.18);

          margin-bottom: 16px;
        }

        .welcome-card span {
          color: var(--yellow);

          font-size: 0.72rem;
          font-weight: 700;

          text-transform: uppercase;

          letter-spacing: 1.5px;
        }

        .welcome-card h2 {
          margin-top: 7px;

          font-size: 1.5rem;

          letter-spacing: -1px;
        }

        .welcome-card p {
          color: #a0a0a0;

          font-size: 0.82rem;

          margin-top: 8px;
        }

        .info-grid {
          display: grid;

          grid-template-columns: repeat(2, 1fr);

          gap: 12px;
        }

        .info-card {
          min-height: 108px;

          display: flex;
          flex-direction: column;
          justify-content: space-between;

          padding: 17px;

          background: #171717;

          border: 1px solid rgba(255, 255, 255, 0.06);

          border-radius: 13px;
        }

        .info-card small {
          display: block;

          color: #757575;

          font-size: 0.72rem;

          margin-bottom: 3px;
        }

        .info-icon {
          width: 30px;
          height: 30px;

          display: flex;
          align-items: center;
          justify-content: center;

          border-radius: 7px;

          background: rgba(245, 197, 24, 0.1);

          color: var(--yellow);

          font-size: 0.8rem;
          font-weight: 800;
        }

        .info-card strong {
          display: block;

          color: #dcdcdc;

          font-size: 0.88rem;
        }

        /* FOOTER */

        .footer {
          min-height: 70px;

          display: flex;
          align-items: center;

          border-top: 1px solid rgba(255, 255, 255, 0.06);

          color: #666666;

          font-size: 0.8rem;
        }

        .footer-content {
          display: flex;
          align-items: center;
          justify-content: space-between;
        }

        .footer strong {
          color: #9b9b9b;
        }

        /* RESPONSIVO */

        @media (max-width: 900px) {
          .main {
            padding: 80px 0;
          }

          .hero {
            grid-template-columns: 1fr;

            gap: 65px;
          }

          .hero-text {
            max-width: 750px;
          }

          .visual {
            min-height: initial;
          }

          .panel {
            max-width: 600px;
          }
        }

        @media (max-width: 600px) {
          .header {
            height: 74px;
          }

          .brand-logo {
            width: 43px;
            height: 49px;
          }

          .brand-name {
            font-size: 1.25rem;
          }

          .login-button {
            padding: 9px 17px;
          }

          .main {
            padding: 65px 0;
          }

          .hero h1 {
            font-size: 3.4rem;

            letter-spacing: -3px;
          }

          .hero-description {
            font-size: 1rem;
          }

          .primary-button {
            width: 100%;
          }

          .visual {
            display: none;
          }

          .footer-content {
            flex-direction: column;
            align-items: flex-start;

            gap: 5px;

            padding: 20px 0;
          }
        }
      `}</style>

      <div className="page">

        {/* HEADER */}

        <header className="header">
          <div className="container navbar">

            <div className="brand">

              {/* Logo TigreGym */}
              <svg
                className="brand-logo"
                viewBox="0 0 120 135"
                xmlns="http://www.w3.org/2000/svg"
                aria-label="Logo TigreGym"
              >
                {/* Escudo */}
                <path
                  d="
                    M60 4
                    L108 21
                    V65
                    C108 96 88 119 60 131
                    C32 119 12 96 12 65
                    V21 Z
                  "
                  fill="#F5C518"
                />

                <path
                  d="
                    M60 11
                    L101 26
                    V64
                    C101 90 84 111 60 122
                    C36 111 19 90 19 64
                    V26 Z
                  "
                  fill="#080808"
                />

                {/* Faixa branca */}
                <path
                  d="M19 39 H101 V55 H19 Z"
                  fill="#FFFFFF"
                />

                {/* Faixa preta */}
                <path
                  d="M19 46 H101 V51 H19 Z"
                  fill="#080808"
                />

                {/* Orelhas */}
                <path
                  d="
                    M34 48
                    L25 39
                    L29 61
                    L40 66 Z
                  "
                  fill="#F5C518"
                />

                <path
                  d="
                    M86 48
                    L95 39
                    L91 61
                    L80 66 Z
                  "
                  fill="#F5C518"
                />

                {/* Cabeça do tigre */}
                <path
                  d="
                    M60 43
                    L84 55
                    L81 83
                    L70 99
                    L60 105
                    L50 99
                    L39 83
                    L36 55 Z
                  "
                  fill="#F5C518"
                />

                {/* Rosto */}
                <path
                  d="
                    M60 51
                    L76 59
                    L74 79
                    L66 91
                    L60 96
                    L54 91
                    L46 79
                    L44 59 Z
                  "
                  fill="#080808"
                />

                {/* Listra */}
                <path
                  d="
                    M60 51
                    L55 65
                    L60 62
                    L65 65 Z
                  "
                  fill="#F5C518"
                />

                {/* Olhos */}
                <path
                  d="M48 69 L57 72 L50 76 Z"
                  fill="#FFFFFF"
                />

                <path
                  d="M72 69 L63 72 L70 76 Z"
                  fill="#FFFFFF"
                />

                {/* Nariz */}
                <path
                  d="M55 82 H65 L60 88 Z"
                  fill="#F5C518"
                />

                {/* Boca */}
                <path
                  d="
                    M60 88 L54 94
                    M60 88 L66 94
                  "
                  fill="none"
                  stroke="#FFFFFF"
                  strokeWidth="2.5"
                  strokeLinecap="round"
                />

                {/* Halter */}
                <rect
                  x="39"
                  y="109"
                  width="42"
                  height="5"
                  rx="2.5"
                  fill="#FFFFFF"
                />

                <rect
                  x="31"
                  y="104"
                  width="7"
                  height="15"
                  rx="2"
                  fill="#F5C518"
                />

                <rect
                  x="25"
                  y="107"
                  width="6"
                  height="9"
                  rx="2"
                  fill="#FFFFFF"
                />

                <rect
                  x="82"
                  y="104"
                  width="7"
                  height="15"
                  rx="2"
                  fill="#F5C518"
                />

                <rect
                  x="89"
                  y="107"
                  width="6"
                  height="9"
                  rx="2"
                  fill="#FFFFFF"
                />
              </svg>

              <div className="brand-name">
                Tigre<span>Gym</span>
              </div>

            </div>

            <Link
              href="/login"
              className="login-button"
            >
              Login
            </Link>

          </div>
        </header>

        {/* CONTEÚDO */}

        <main className="main">
          <div className="container hero">

            {/* TEXTO */}
            <div className="hero-text">

              <h1>
                Academia simples.
                <br />
                Do jeito que
                <br />
                <span>deveria ser.</span>
              </h1>

              <p className="hero-description">
                O TigreGym foi criado para facilitar a rotina das academias e
                melhorar a experiência dos alunos. Um sistema moderno,
                organizado e fácil de utilizar, pensado para Criciúma e região.
              </p>

              <div className="buttons">
                <Link
                  href="/login"
                  className="primary-button"
                >
                  Entrar no TigreGym

                  <span className="button-arrow">
                    →
                  </span>
                </Link>
              </div>

            </div>

            {/* VISUAL DO SISTEMA */}
            <div className="visual">

              <div className="visual-glow" />

              <div className="panel">

                <div className="panel-header">

                  <div className="panel-title">

                    {/* Logo pequena */}
                    <svg
                      className="small-logo"
                      viewBox="0 0 120 135"
                      xmlns="http://www.w3.org/2000/svg"
                    >
                      <path
                        d="
                          M60 4
                          L108 21
                          V65
                          C108 96 88 119 60 131
                          C32 119 12 96 12 65
                          V21 Z
                        "
                        fill="#F5C518"
                      />

                      <path
                        d="
                          M60 11
                          L101 26
                          V64
                          C101 90 84 111 60 122
                          C36 111 19 90 19 64
                          V26 Z
                        "
                        fill="#080808"
                      />

                      <path
                        d="M19 39 H101 V55 H19 Z"
                        fill="#FFFFFF"
                      />

                      <path
                        d="M19 46 H101 V51 H19 Z"
                        fill="#080808"
                      />

                      <path
                        d="
                          M34 48
                          L25 39
                          L29 61
                          L40 66 Z
                        "
                        fill="#F5C518"
                      />

                      <path
                        d="
                          M86 48
                          L95 39
                          L91 61
                          L80 66 Z
                        "
                        fill="#F5C518"
                      />

                      <path
                        d="
                          M60 43
                          L84 55
                          L81 83
                          L70 99
                          L60 105
                          L50 99
                          L39 83
                          L36 55 Z
                        "
                        fill="#F5C518"
                      />

                      <path
                        d="
                          M60 51
                          L76 59
                          L74 79
                          L66 91
                          L60 96
                          L54 91
                          L46 79
                          L44 59 Z
                        "
                        fill="#080808"
                      />

                      <path
                        d="M48 69 L57 72 L50 76 Z"
                        fill="#FFFFFF"
                      />

                      <path
                        d="M72 69 L63 72 L70 76 Z"
                        fill="#FFFFFF"
                      />

                      <rect
                        x="39"
                        y="109"
                        width="42"
                        height="5"
                        rx="2.5"
                        fill="#FFFFFF"
                      />

                      <rect
                        x="31"
                        y="104"
                        width="7"
                        height="15"
                        rx="2"
                        fill="#F5C518"
                      />

                      <rect
                        x="82"
                        y="104"
                        width="7"
                        height="15"
                        rx="2"
                        fill="#F5C518"
                      />
                    </svg>

                    <div>
                      <strong>TigreGym</strong>
                      <span>Gestão de academia</span>
                    </div>

                  </div>

                  <div className="status">
                    <span className="status-dot" />
                    Sistema
                  </div>

                </div>

                <div className="welcome-card">

                  <span>
                    Bem-vindo
                  </span>

                  <h2>
                    Sua academia em um só lugar.
                  </h2>

                  <p>
                    Simples para administrar. Fácil para utilizar.
                  </p>

                </div>

                <div className="info-grid">

                  <div className="info-card">

                    <div className="info-icon">
                      A
                    </div>

                    <div>
                      <small>Gestão</small>
                      <strong>Alunos</strong>
                    </div>

                  </div>

                  <div className="info-card">

                    <div className="info-icon">
                      P
                    </div>

                    <div>
                      <small>Organização</small>
                      <strong>Planos</strong>
                    </div>

                  </div>

                  <div className="info-card">

                    <div className="info-icon">
                      M
                    </div>

                    <div>
                      <small>Controle</small>
                      <strong>Matrículas</strong>
                    </div>

                  </div>

                  <div className="info-card">

                    <div className="info-icon">
                      TG
                    </div>

                    <div>
                      <small>Identidade</small>
                      <strong>TigreGym</strong>
                    </div>

                  </div>

                </div>

              </div>

            </div>

          </div>
        </main>

        {/* FOOTER */}

        <footer className="footer">
          <div className="container footer-content">

            <div>
              © 2026 <strong>TigreGym</strong>
            </div>

            <div>
              Criciúma - Santa Catarina
            </div>

          </div>
        </footer>

      </div>
    </>
  );
}