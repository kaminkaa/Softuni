class Task {
    constructor(title, deadline) {
        if (deadline < Date.now()) {
            throw new Error('Date is in the past');
        }
        this.title = title;
        this._deadline = deadline;
        this.status = 'Open';
    }

    set _deadline (value) {
        if (value < Date.now) {
            throw new Error('Date is in the past');
        }
        this.deadline = value;
    }

    isOverdue() {
        return (this.deadline < Date.now() && (this.status === 'Open' || this.status === 'In Progress'));
    }

    static comparator(a, b) {
        if (a.isOverdue() && a.status !== 'Complete') {
            if (!b.isOverdue()) {
                return -1;
            } else if (b.status !== 'Complete') {
                return b.deadline - a.deadline;
            }
        }

        if (b.isOverdue() && b.status !== 'Complete') {
            if (!a.isOverdue()) {
                return 1;
            } else if (a.status !== 'Complete') {
                return b.deadline - a.deadline;
            }
        }

        if (a.status === b.status) {
            return 0;
        }

        if (a.status === 'In Progress') {
            return -1;
        }

        if (b.status === 'In Progress') {
            return 1;
        }



    }

    toString() {
        if (this.status === 'Complete') {
            return '[' + "\u2714" + '] ' + this.title;
        }

        if (this.isOverdue()) {
            return '[' + "\u26A0" + '] ' + this.title + ' (overdue)';
        }

        if (this.status === 'Open') {
            return '[' + "\u2731" + '] ' + this.title + ' (deadline: ' + this.deadline + ')';
        }

        if (this.status === 'In Progress') {
            return '[' + "\u219D " + '] ' + this.title + ' (deadline: ' + this.deadline + ')';
        }
    }
}