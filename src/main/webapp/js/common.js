
function copyToClipboard(text) {
	window.prompt("Copy to clipboard: Ctrl+C, Enter", text);
	// var copyEvent = new ClipboardEvent('copy', { dataType: 'text/plain', data: text } );
	// document.dispatchEvent(copyEvent);
}

function getReadableFileSizeString(fileSizeInBytes) {
    var i = -1;
    var byteUnits = [' kB', ' MB', ' GB' ];
    do {
        fileSizeInBytes = fileSizeInBytes / 1024;
        i++;
    } while (fileSizeInBytes > 1024);

    return Math.max(fileSizeInBytes, 0.1).toFixed(1) + byteUnits[i];
};
