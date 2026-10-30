export class Matricula {
  constructor(
    public id: number | null,
    public aluno: string,
    public plano: string,
    public dataInicio: string,
    public dataVencimento: string,
    public status: string
  ) {}
}

export interface MatriculaFormProps {
  matriculaExistente?: Matricula;
}
