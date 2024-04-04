char* convertToTitle(int columnNumber) {
    char* res = malloc(sizeof(char) * 15);
    if(columnNumber <= 26) {
        res[0] = 'A' - 1 + columnNumber;
        res[1] = '\0';
        return res;
    }

    res[14] = '\0';
    int idx = 13;
    while(columnNumber > 0) {
        int last = columnNumber % 26;
        columnNumber = columnNumber / 26;
        if(!last) {
            res[idx] = 'Z';
            idx--;
            columnNumber--;
        }

        if(last) {
            res[idx] = 'A' - 1 + last;
            idx--;
        }

        if(columnNumber <= 26) {
            res[idx] = 'A' - 1 + columnNumber;
            break;
        }
    }

    return res + idx;
}