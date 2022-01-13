export class CC_Notices {
    constructor(
        public title:string,
        public description:string,
    ){}
}
export interface ICC_Notices {
    noticeId:number,
    title: string,
    description:string,
    pub_by: string,
    pub_date: Date
}