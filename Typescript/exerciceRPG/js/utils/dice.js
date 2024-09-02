export function roll(face) {
    let result = Math.ceil(Math.random() * face);
    return result;
}
export var DiceResultType;
(function (DiceResultType) {
    DiceResultType[DiceResultType["CRITIC"] = 0] = "CRITIC";
    DiceResultType[DiceResultType["SUCCESS"] = 1] = "SUCCESS";
    DiceResultType[DiceResultType["FAIL"] = 2] = "FAIL";
    DiceResultType[DiceResultType["FUMBLE"] = 3] = "FUMBLE";
})(DiceResultType || (DiceResultType = {}));
