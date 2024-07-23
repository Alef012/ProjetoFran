# Use a imagem oficial do PostgreSQL do Docker Hub
FROM postgres:latest

# Defina variáveis de ambiente para configuração do PostgreSQL
ENV POSTGRES_USER=posgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=db

# Copie arquivos SQL ou scripts de inicialização, se necessário
# COPY path/to/your-init.sql /docker-entrypoint-initdb.d/

# Exponha a porta padrão do PostgreSQL
EXPOSE 5432

# Comando para iniciar o PostgreSQL (já configurado pela imagem base)
CMD ["postgres"]
