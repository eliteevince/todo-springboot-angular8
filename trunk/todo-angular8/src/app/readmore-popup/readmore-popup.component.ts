import {Component, OnInit, ViewChild} from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {ToDo} from '../../utils/constants';
@Component({
    selector: 'app-readmore-popup',
    templateUrl: './readmore-popup.component.html',
    styleUrls: ['./readmore-popup.component.css']
})
export class ReadmorePopupComponent implements OnInit {
    closeResult: string;
    constructor(private modalService: NgbModal) {}
    @ViewChild('readmore', {static: true}) templete;
    message: string;
    todo: ToDo;
    ngOnInit() {
    }
    cofirmed() {
    }

    open(content: any) {
        return this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result;
    }
    /**
     * Todo : open readmore popup
     */
    openReadMore(todo: ToDo) {
        this.todo = todo;
        return this.open(this.templete);
    }
}