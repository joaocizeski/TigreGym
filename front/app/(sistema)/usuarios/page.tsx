import Link from "next/link";

export default function Usuarios(){
    return (
    
    <div>
        <div>
            <div>
                <h1>Gestao de Usuarios</h1>
            </div>
            <Link href="/usuarios/novo"></Link>
        </div>

        <div>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>Nome</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        <td>João</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
    )
}