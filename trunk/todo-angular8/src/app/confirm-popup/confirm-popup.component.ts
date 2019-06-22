import {Component, OnInit, ViewChild} from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-confirm-popup',
    templateUrl: './confirm-popup.component.html',
    styleUrls: ['./confirm-popup.component.css']
})
export class ConfirmPopupComponent {
    closeResult: string;
    constructor(private modalService: NgbModal) {}
    @ViewChild('confirm', {static: true}) templete;
    message: string;

    open(content: any) {
        return this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result;
    }
    /**
     * Todo : open confirm popup
     */
    openConfirmDialog(msg: string) {
        this.message = msg;
        return this.open(this.templete);
    }
}
