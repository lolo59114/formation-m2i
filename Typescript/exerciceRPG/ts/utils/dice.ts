export function roll(face: number): number {
    let result: number = Math.ceil(Math.random()*face);
    return result;
}

export enum DiceResultType {
    "CRITIC",
    "SUCCESS",
    "FAIL",
    "FUMBLE"
}