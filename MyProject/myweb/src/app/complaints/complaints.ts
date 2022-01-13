export class Complaints {
    constructor(
        studentComplaintId:number,
        studentPrn:number,
        complaintSubjectName:String,
        complaintDescription:String,
        complaintDate:Date,
        complaintStatus:String
    ){}
}
export interface IComplaints {
    studentComplaintId:number,
    studentPrn:number,
    complaintSubjectName:String,
    complaintDescription:String,
    complaintDate:Date,
    complaintStatus:String
}