export class CC_Sotm {
    constructor(
        public studentprn:number,
        public description:string,
    ){}
}
export interface ICC_SOTM {
    stomId:number,
    monthName: string,
    studentprn:number,
    description: string
}