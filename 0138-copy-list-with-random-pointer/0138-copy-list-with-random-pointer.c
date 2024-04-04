/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *next;
 *     struct Node *random;
 * };
 */

struct Node * getRandom(struct Node * nhead , struct Node * head , struct Node * random)
{
    int i = 0;
    while(head)
    {
        if(head == random)
            break;
        i++;
        head = head->next;
    }
    while(i)
    {
        nhead = nhead->next;
        i--;
    }
    return nhead;
}
void insert(struct Node ** head, struct Node ** tail,int data)
{
    struct Node *n = malloc(sizeof(struct Node));
    n->val = data;
    n->next = NULL;
    n->random = NULL;
    if(*head==NULL)
    {
        *head = n;
        *tail = n;
        return ;
    }
    (*tail)->next = n;
    *tail = n;
    return ;
}

struct Node* copyRandomList(struct Node* head) {

    struct Node* cur = head;
    struct Node * newhead = NULL;
    struct Node * tail = NULL;

    while(cur)
    {
        insert(&newhead,&tail,cur->val);
        cur = cur->next;
    }

    struct Node * cur2 = newhead ;
    cur = head ;
    while(cur)
    {
        if(cur->random)
        {
            cur2->random = getRandom(newhead,head,cur->random);
        }
        cur = cur->next;
        cur2 = cur2->next;
    }
    return newhead;

}