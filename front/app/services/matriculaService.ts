import { Matricula } from "../types/matricula";
import api from "./api";

function dadosMatricula(matricula: Matricula) {
    return {
        aluno_id: matricula.alunoId,
        plano_id: matricula.planoId,
        dataInicio: matricula.dataInicio,
        dataVencimento: matricula.dataVencimento,
    };
}

export async function buscarListaMatriculas(): Promise<Matricula[]> {
    const dados = await api.get<Matricula[]>("http://localhost:8080/matriculas");

    if (dados.status == 200) {
        return dados.data;
    }

    return [];
}

export async function deletarMatricula(id: number): Promise<number> {
    var dados = await api.delete(
        "http://localhost:8080/matriculas/" + id + "/excluir"
    );

    return dados.status;
}

export async function atualizarStatusMatricula(matricula: Matricula): Promise<void> {
    var novoStatus = {};

    if (matricula.status === "ATIVO") {
        novoStatus = { status: "BLOQUEADO" };
    } else {
        novoStatus = { status: "ATIVO" };
    }

    var dadosRetorno = await api.patch(
        "http://localhost:8080/matriculas/" + matricula.id + "/status",
        novoStatus
    );

    if (dadosRetorno.status == 200) {
        alert("Status atualizado com sucesso!");
    } else {
        alert(dadosRetorno.data);
        return;
    }
}

export async function consultaMatriculaPorId(id: number): Promise<Matricula> {
    const valorMatriculaBack = await api.get<Matricula>(
        "http://localhost:8080/matriculas/" + id
    );

    return valorMatriculaBack.data;
}

export async function atualizarMatricula(matricula: Matricula): Promise<Matricula> {
    var dadosRetorno = await api.put<Matricula>(
        "http://localhost:8080/matriculas/" + matricula.id,
        dadosMatricula(matricula)
    );

    return dadosRetorno.data;
}

export async function salvarMatricula(matricula: Matricula): Promise<Matricula> {
    var dadosRetorno = await api.post<Matricula>(
        "http://localhost:8080/matriculas",
        dadosMatricula(matricula)
    );

    return dadosRetorno.data;
}
