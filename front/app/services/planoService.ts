import { Plano } from "../types/plano";
import api from "./api";

export async function buscarListaPlanos(): Promise<Plano[]> {
    const dados = await api.get<Plano[]>("http://localhost:8080/planos");

    if (dados.status == 200) {
        return dados.data;
    }

    return [];
}

export async function deletarPlano(id: number): Promise<number> {
    var dados = await api.delete("http://localhost:8080/planos/" + id + "/excluir");
    return dados.status;
}

export async function atualizarStatusPlano(plano: Plano): Promise<void> {
    var novoStatus = {};

    if (plano.status === "ATIVO") {
        novoStatus = { status: "BLOQUEADO" };
    } else {
        novoStatus = { status: "ATIVO" };
    }

    var dadosRetorno = await api.patch(
        "http://localhost:8080/planos/" + plano.id + "/status",
        novoStatus
    );

    if (dadosRetorno.status == 200) {
        alert("Status atualizado com sucesso!");
    } else {
        alert(dadosRetorno.data);
        return;
    }
}

export async function consultaPlanoPorId(id: number): Promise<Plano> {
    const valorPlanoBack = await api.get<Plano>("http://localhost:8080/planos/" + id);
    return valorPlanoBack.data;
}

export async function atualizarPlano(plano: Plano): Promise<Plano> {
    var dadosRetorno = await api.put<Plano>(
        "http://localhost:8080/planos/" + plano.id,
        plano
    );

    return dadosRetorno.data;
}

export async function salvarPlano(plano: Plano): Promise<Plano> {
    var dadosRetorno = await api.post<Plano>(
        "http://localhost:8080/planos",
        plano
    );

    return dadosRetorno.data;
}
