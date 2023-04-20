import {EngineObject} from "../types";

export interface CropStageObject extends EngineObject {
    stage: number;
}

export interface CropObject extends EngineObject {
    stages: Array<CropStageObject>;
}
