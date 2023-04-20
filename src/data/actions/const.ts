export enum GAME_ACTIONS {
    ATTACK = 'ATTACK',
    CUT = 'CUT',
    TAKE = 'TAKE'
}

export type GameActionsUnion = keyof typeof GAME_ACTIONS;