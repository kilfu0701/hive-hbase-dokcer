# memo

## Hadoop 3 default ports

```
0	dfs.balancer.address	0.0.0.0:0
9866	dfs.datanode.address	0.0.0.0:9866
9864	dfs.datanode.http.address	0.0.0.0:9864
9865	dfs.datanode.https.address	0.0.0.0:9865
9867	dfs.datanode.ipc.address	0.0.0.0:9867
8111	dfs.federation.router.admin-address	0.0.0.0:8111
50071	dfs.federation.router.http-address	0.0.0.0:50071
50072	dfs.federation.router.https-address	0.0.0.0:50072
8888	dfs.federation.router.rpc-address	0.0.0.0:8888
8480	dfs.journalnode.http-address	0.0.0.0:8480
8481	dfs.journalnode.https-address	0.0.0.0:8481
8485	dfs.journalnode.rpc-address	0.0.0.0:8485
0	dfs.mover.address	0.0.0.0:0
50100	dfs.namenode.backup.address	0.0.0.0:50100
50105	dfs.namenode.backup.http-address	0.0.0.0:50105
9870	dfs.namenode.http-address	0.0.0.0:9870
9871	dfs.namenode.https-address	0.0.0.0:9871
9868	dfs.namenode.secondary.http-address	0.0.0.0:9868
9869	dfs.namenode.secondary.https-address	0.0.0.0:9869
50200	dfs.provided.aliasmap.inmemory.dnrpc-address	0.0.0.0:50200
2181	hadoop.registry.zk.quorum	localhost:2181
10020	mapreduce.jobhistory.address	0.0.0.0:10020
10033	mapreduce.jobhistory.admin.address	0.0.0.0:10033
19888	mapreduce.jobhistory.webapp.address	0.0.0.0:19888
19890	mapreduce.jobhistory.webapp.https.address	0.0.0.0:19890
0	yarn.nodemanager.address	${yarn.nodemanager.hostname}:0
8049	yarn.nodemanager.amrmproxy.address	0.0.0.0:8049
8048	yarn.nodemanager.collector-service.address	${yarn.nodemanager.hostname}:8048
8040	yarn.nodemanager.localizer.address	${yarn.nodemanager.hostname}:8040
8042	yarn.nodemanager.webapp.address	${yarn.nodemanager.hostname}:8042
8044	yarn.nodemanager.webapp.https.address	0.0.0.0:8044
8032	yarn.resourcemanager.address	${yarn.resourcemanager.hostname}:8032
8033	yarn.resourcemanager.admin.address	${yarn.resourcemanager.hostname}:8033
8031	yarn.resourcemanager.resource-tracker.address	${yarn.resourcemanager.hostname}:8031
8030	yarn.resourcemanager.scheduler.address	${yarn.resourcemanager.hostname}:8030
8088	yarn.resourcemanager.webapp.address	${yarn.resourcemanager.hostname}:8088
8090	yarn.resourcemanager.webapp.https.address	${yarn.resourcemanager.hostname}:8090
8089	yarn.router.webapp.address	0.0.0.0:8089
8091	yarn.router.webapp.https.address	0.0.0.0:8091
8047	yarn.sharedcache.admin.address	0.0.0.0:8047
8045	yarn.sharedcache.client-server.address	0.0.0.0:8045
8046	yarn.sharedcache.uploader.server.address	0.0.0.0:8046
8788	yarn.sharedcache.webapp.address	0.0.0.0:8788
10200	yarn.timeline-service.address	${yarn.timeline-service.hostname}:10200
8188	yarn.timeline-service.webapp.address	${yarn.timeline-service.hostname}:8188
8190	yarn.timeline-service.webapp.https.address	${yarn.timeline-service.hostname}:8190
```
