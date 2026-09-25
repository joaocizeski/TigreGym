export class Plano {
  constructor(
    public id: number | null,
    public nome: string,
    public descricao: string,
    public valor: string,
    public duracaoEmMeses: string,
    public status: string
  ) {}
}

export interface PlanoFormProps {
  planoExistente?: Plano;
}
