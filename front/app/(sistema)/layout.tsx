import Footer from "../components/Footer";
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

export default function SistemaLayout({ children }) {
  return (
    <div className="flex">
      <Sidebar />

      <div className="flex min-h-screen min-w-0 flex-1 flex-col">
        <Header />

        <main className="flex-1 overflow-x-hidden">{children}</main>

        <Footer />
      </div>
    </div>
  );
}
