function flatten(obj, prefix = "") {
    for (var key in obj) {
        var value = obj[key];
        delete obj[key];
        obj[prefix + key] = value;
        if (typeof(value) === "object") {
            obj = Object.assign(obj, flatten(value, prefix + key));
            delete obj[prefix + key];
            return obj;
        }
    }
    return obj;
}