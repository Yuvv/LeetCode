class EventEmitter {

    constructor() {
        this.events = {};
    }

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        let exists = this.events[eventName];
        if (exists) {
            exists.push(callback);
        } else {
            exists = [callback];
            this.events[eventName] = exists;
        }
        let that = this;
        return {
            unsubscribe: () => {
                let idx = that.events[eventName].indexOf(callback);
                if (idx >= 0) {
                    that.events[eventName].splice(idx, 1);
                }
            }
        };
    }

    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        if (this.events[eventName]) {
            return this.events[eventName].map((cb) => cb(...args));
        }
        return [];
    }
}

