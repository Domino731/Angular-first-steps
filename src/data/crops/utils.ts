import {ENGINE_OBJECT_GROUPS, ENGINE_OBJECTS_TYPES, SPRITE_SRC} from "../types";
import {TREE_ITEMS} from "../environment/types";
import {TOOLS} from "../tools/types";
import {CropStageObject} from "./types";

/** Function that creating stages for crop
 * @param xOffsetFirst - first stage xOffset
 * @param yOffset - y offset of all stages
 * @param stages - amount of all stages
 * @param cropName - name of crop
 * */
export const cropStagesFactory = (xOffsetFirst: number, yOffset: number, stages: number, cropName: string): Array<CropStageObject> => {
    const stagesArray: Array<CropStageObject> = [];

    for (let i = 0; i < stages; i++) {
        const stage: number = i + 1;
        const stageObject: CropStageObject = {
            group: ENGINE_OBJECT_GROUPS.ENVIRONMENT,
            type: ENGINE_OBJECTS_TYPES.TREES,
            id: `${cropName} stage ${stage}`,
            name: `${cropName} stage ${stage}`,
            hp: 800,
            sprite: {
                // @ts-ignore
                src: SPRITE_SRC.CROPS,
                position: {
                    x: xOffsetFirst + (7 * i),
                    y: yOffset,
                }
            },
            tools: [TOOLS.AXE],
            destroyable: true,
            checkboxes: [],
            items: [TREE_ITEMS.WOOD],
            stage: stage
        }

        stagesArray.push(stageObject)
    }

    return stagesArray;
}