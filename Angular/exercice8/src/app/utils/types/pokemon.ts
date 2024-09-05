export type Pokemon = {
  name: string,
  description: string,
  attacks: Attack[],
  types: string[],
  area: Area
}

export type Attack = {
  name: string,
  description: string,
  damage: number,
}

export type Area = {
  name: string,
  region: string,
}
