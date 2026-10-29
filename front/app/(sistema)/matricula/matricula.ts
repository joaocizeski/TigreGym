export class Matricula {
  constructor(
    public id: number | null,
    public alunoId: number | null,
    public aluno: string,
    public planoId: number | null,
    public plano: string,
    public dataInicio: string,
    public dataVencimento: string,
    public status: string
  ) {}
}

export interface MatriculaFormProps {
  matriculaExistente?: Matricula;
}
