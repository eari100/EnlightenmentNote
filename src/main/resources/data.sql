INSERT INTO
    categories(category_seq, name, created_date, modified_date)
VALUES
    ('1', '깨점노트', now(), now()), ('2', '묵상노트', now(), now());

INSERT INTO
    posts(post_seq, title, content, author, category_id, created_date, modified_date)
VALUES
    ('1', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('2', '묵상노트1', '묵상 굳', '정마태', '2', now(), now()),
    ('3', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('4', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('5', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('6', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('7', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('8', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('9', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('10', '깨점노트1', '수업 좋았다.', '김요한', '1', now(), now()),
    ('11', '깨점노트1', '수업 좋았다.', '11번째', '1', now(), now()),
    ('12', '묵상노트1', '수업 좋았다.', '12번째', '2', now(), now());