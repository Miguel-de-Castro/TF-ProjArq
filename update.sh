# PORT 8765
cd Tarefa1_SistemaDeVendas/ApiGatewayServico
mvn clean package
docker build -t gateway:latest .

cd ../..

# PORT 8200
cd Tarefa1_SistemaDeVendas/EstoqueServico
mvn clean package
docker build -t estoque:latest .

cd ../..

# 8761
cd Tarefa1_SistemaDeVendas/NamingServerServico
mvn clean package
docker build -t nameserver:latest .

cd ../..

# PORT 8100
cd Tarefa1_SistemaDeVendas/NotaFiscalServico
mvn clean package
docker build -t nota:latest .

cd ../..

# PORT 8080
cd Tarefa1_SistemaDeVendas/SvBkEndProt
mvn clean package
docker build -t prototipo:latest .

cd ../..