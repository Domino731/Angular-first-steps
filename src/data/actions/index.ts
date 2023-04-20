import {GAME_ACTIONS} from "./const";
import {GameActionInterface} from "./types";

export const GameActions: Array<GameActionInterface> = [
    {
        id: GAME_ACTIONS.CUT,
        name: 'Cut'
    },
    {
        id: GAME_ACTIONS.ATTACK,
        name: 'Attack'
    },
    {
        id: GAME_ACTIONS.TAKE,
        name: 'Take'
    },
]