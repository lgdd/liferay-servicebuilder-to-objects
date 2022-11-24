create index IX_5E2AE4CD on DEV24_AfterSalesRequest (groupId);
create index IX_3FF935A7 on DEV24_AfterSalesRequest (status, groupId);
create index IX_15FD8931 on DEV24_AfterSalesRequest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EF08A7F3 on DEV24_AfterSalesRequest (uuid_[$COLUMN_LENGTH:75$], groupId);