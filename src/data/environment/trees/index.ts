import {TreeObject} from "../types";
import {treeFactory} from "./utils";
import {TREE_NAMES} from "./const";

// create trees using treeFactory function which is creating tree with stages (1-5)
const Maple: TreeObject = treeFactory(TREE_NAMES.MAPLE);
const Oak: TreeObject = treeFactory(TREE_NAMES.MAPLE);
const Pine: TreeObject = treeFactory(TREE_NAMES.PINE);
const Mahogany: TreeObject = treeFactory(TREE_NAMES.MAHOGANY);

/** Array with all trees */
export const Trees: Array<TreeObject> = [
    Maple,
    Oak,
    Pine,
    Mahogany
]