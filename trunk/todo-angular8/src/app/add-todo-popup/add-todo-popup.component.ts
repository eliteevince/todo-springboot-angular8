import {Component, Input, ViewChild, EventEmitter, Output} from '@angular/core';
import {FormControl} from '@angular/forms';
import {TodoserviceService} from '../todoservice.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {ToDo} from '../../utils/constants';
import {ToastrService} from 'ngx-toastr';

export interface ConfirmModel {
    title: string;
    message: string;
}
@Component({
    selector: 'app-add-todo-popup',
    templateUrl: './add-todo-popup.component.html',
    styleUrls: ['./add-todo-popup.component.css']
})
export class AddTodoPopupComponent {
    addUpdate: string;
    eTime: FormControl;
    closeResult: string;
    currentDate: any;
    @Input('todo') todo: ToDo;
    @Output() getToDos = new EventEmitter<boolean>();
    @ViewChild('content', {static: true}) templete;
    constructor(private modalService: NgbModal, private todoserviceService: TodoserviceService, private toastr: ToastrService) {
    }
    /**
     * Todo : Call method from parent component to open popup
     */
    callFromParent(todo: ToDo) {
        this.addUpdate = "Edit Event";
        this.todo = todo;
        this.todo.eDate = new Date(this.todo.eventTimeMilis);
        this.todo.eTime = {hour: this.todo.eDate.getHours(), minute: this.todo.eDate.getMinutes(), second: this.todo.eDate.getSeconds()};
        this.open(this.templete);
    }
    /**
     * Todo : open popup
     */
    callBySelf() {
        this.addUpdate = "Add Event";
        this.todo = new ToDo();
        this.open(this.templete);
    }
    open(content: any) {
        let cDate = new Date();
        this.currentDate = {
            year: cDate.getFullYear(),
            month: cDate.getMonth() + 1,
            day: cDate.getDate()
        };
        this.eTime = new FormControl('', (control: FormControl) => {
            const value = control.value;
            if (!value) {return null;}
            if (this.todo.eDate == undefined || this.todo.eDate == null) {
                return {dateSelect: true};
            }
            this.todo.eDate.setHours(value.hour);
            this.todo.eDate.setMinutes(value.minute);
            let selecttedMilis = this.todo.eDate.getTime();
            if (selecttedMilis <= cDate.getTime()) {
                return {timeMax: true};
            }
            return {};
        });

        this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
        }, (reason) => {
            this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        });
    }
    /**
     * Todo : handle popup close
     */
    private getDismissReason(reason: any): string {
        if (reason === ModalDismissReasons.ESC) {
            return 'by pressing ESC';
        } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
            return 'by clicking on a backdrop';
        } else {
            return `with: ${reason}`;
        }
    }
    /**
     * Todo : Apply validations and save the Todo item
     */
    validationMsg = {
        title: "",
        description: "",
        eDate: "",
        eTime: "",
        dateTime: ""
    };
    validateData() {
        let isValid = true;
        if (this.todo.title == undefined || this.todo.title == null || this.todo.title == '') {
            this.validationMsg.title = "Please enter title";
            isValid = false;
        } else {
            this.validationMsg.title = undefined;
        }
        if (this.todo.description == undefined || this.todo.description == null || this.todo.description == '') {
            this.validationMsg.description = "Please enter description";
            isValid = false;
        } else {
            this.validationMsg.description = undefined;
        }
        if (this.todo.eDate == undefined || this.todo.eDate == null) {
            this.validationMsg.eDate = "Please select date";
            isValid = false;
        } else {
            this.validationMsg.eDate = undefined;
        }
        if (this.eTime.status == 'INVALID') {
            this.validationMsg.eTime = "Time Not proper";
            isValid = false;
        } else {
            this.validationMsg.eTime = undefined;
        }

        this.todo.eventTimeMilis = this.todo.eDate.getTime();
        if (isValid) {
            this.todo.isRead = false;

            this.todoserviceService.saveToDo(this.todo).subscribe(
                (res: any) => {this.toastr.success(res.msg); this.getToDos.emit(true)},
                err => console.log(err)
            );
            this.modalService.dismissAll('Save click');
        }
    }
}
